package org.redeyefrog.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum RoleType {

    ADMIN,

    PROGRAMMER,

    TESTER,

    USER,

    UNKNOWN;

    public static RoleType find(String code) {
        return Stream.of(values())
                     .filter(type -> StringUtils.equals(code, type.name()))
                     .findAny()
                     .orElse(UNKNOWN);
    }

}
