package org.redeyefrog.security.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.redeyefrog.enums.RoleType;

@Getter
@Setter
@Builder
public class User {

    private String id;

    private String name;

    private String email;

    private RoleType role;

}
