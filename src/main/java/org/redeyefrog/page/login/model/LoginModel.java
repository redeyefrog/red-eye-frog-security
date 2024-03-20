package org.redeyefrog.page.login.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginModel {

    private String username;

    private String password;

}
