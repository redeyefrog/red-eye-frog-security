package org.redeyefrog.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum LoginType {

    PASSWORD,

    SSO_TOKEN,

    UNKNOWN;

    public static LoginType find(String code) {
        return Stream.of(values())
                     .filter(type -> StringUtils.equals(code, type.name()))
                     .findAny()
                     .orElse(PASSWORD);
    }

    public boolean isPassword() {
        return equals(PASSWORD);
    }

}
