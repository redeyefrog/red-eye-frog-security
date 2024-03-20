package org.redeyefrog.page.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public ModelAndView welcome() {
        log.info("Authentication: {}", SecurityContextHolder.getContext().getAuthentication());
        ModelAndView modelAndView = new ModelAndView("welcome/welcome");
        modelAndView.addObject("message", "Welcome to Red Eye Frog");
        return modelAndView;
    }

}
