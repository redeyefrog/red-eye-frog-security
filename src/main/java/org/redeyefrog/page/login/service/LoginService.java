package org.redeyefrog.page.login.service;

import org.redeyefrog.enums.LoginType;
import org.redeyefrog.exception.RedEyeFrogRuntimeException;
import org.redeyefrog.page.login.model.LoginModel;
import org.redeyefrog.persistence.entity.SsoTokenEntity;
import org.redeyefrog.persistence.repository.SsoTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class LoginService {

    @Autowired
    private SsoTokenRepository ssoTokenRepository;

    public LoginModel ssoLogin(String token) {
        SsoTokenEntity ssoTokenEntity = ssoTokenRepository.findById(token)
                                                          .orElseThrow(() -> new RedEyeFrogRuntimeException(MessageFormat.format("Token[{0}] not found", token)));
        String params = ssoTokenEntity.getParams();
        return LoginModel.builder()
                         .username(params)
                         .password(LoginType.SSO_TOKEN.name())
                         .build();
    }

}
