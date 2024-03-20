package org.redeyefrog.security.provider;

import org.redeyefrog.enums.LoginType;
import org.redeyefrog.enums.RoleType;
import org.redeyefrog.persistence.entity.UserEntity;
import org.redeyefrog.persistence.repository.UserRepository;
import org.redeyefrog.security.bean.User;
import org.redeyefrog.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserEntity userEntity = userRepository.findById(username)
                                              .orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("Username[{0}] is invalid", username)));
        LoginType loginType = LoginType.find(password); // For check sso is a bad Design. Wait for new idea.
        if (loginType.isPassword() && !EncryptUtils.matchBCrypt(password, userEntity.getPassword())) {
            throw new UsernameNotFoundException(MessageFormat.format("Password[{0}] is invalid", password));
        }
        RoleType role = RoleType.find(userEntity.getRole().getId());
        User user = User.builder()
                        .id(userEntity.getId())
                        .name(userEntity.getName())
                        .email(userEntity.getEmail())
                        .role(role)
                        .build();
        return new UsernamePasswordAuthenticationToken(user, userEntity.getPassword(), AuthorityUtils.createAuthorityList(role.name()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
