package org.redeyefrog.exception;

public class RedEyeFrogRuntimeException extends RuntimeException {

    public RedEyeFrogRuntimeException(String message) {
        this(message, null);
    }

    public RedEyeFrogRuntimeException(String message, Throwable cause) {
        super(message, cause, true, false);
    }

}
