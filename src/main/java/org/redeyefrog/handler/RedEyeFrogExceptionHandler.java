package org.redeyefrog.handler;

import lombok.extern.slf4j.Slf4j;
import org.redeyefrog.exception.RedEyeFrogRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class RedEyeFrogExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RedEyeFrogRuntimeException.class)
    public ModelAndView onRedEyeFrogRuntimeException(RedEyeFrogRuntimeException e) {
        ModelAndView modelAndView = new ModelAndView("login/error");
        modelAndView.addObject("error_message", e.getMessage());
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ModelAndView onThrowable(Throwable e) {
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView("login/error");
        modelAndView.addObject("error_message", "System error. Please contact administrator");
        return modelAndView;
    }

}
