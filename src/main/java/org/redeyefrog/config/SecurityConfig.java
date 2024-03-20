package org.redeyefrog.config;

import org.redeyefrog.security.provider.SecurityAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests(authorize -> authorize
                                   .antMatchers("/css/**", "/js/**", "/lib/**").permitAll()
                                   .antMatchers("/token/**").permitAll()
                                   .anyRequest().authenticated())
                           .formLogin(login -> login
//                                   .loginPage("/login").permitAll()
                                   .loginProcessingUrl("/perform_login")
                                   .defaultSuccessUrl("/welcome", true)
                           )
                           .logout(logout -> logout
                                   .logoutUrl("/perform_logout")
                                   .logoutSuccessUrl("/login"))
                           .build();
    }

//    @Bean
    WebSecurityCustomizer customizer() {
        // This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
        return web -> {
            web.ignoring()
               .antMatchers("/css/**", "/js/**", "/lib/**");
        };
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, SecurityAuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                           .authenticationProvider(authenticationProvider)
                           .build();
    }

}
