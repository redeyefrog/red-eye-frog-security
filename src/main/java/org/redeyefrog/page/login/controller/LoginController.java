package org.redeyefrog.page.login.controller;

import org.redeyefrog.page.login.model.LoginModel;
import org.redeyefrog.page.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ModelAndView login() throws Exception {
        return new ModelAndView("login/login");
    }

    @GetMapping("/token/{token}")
    public ModelAndView ssoLogin(@PathVariable String token) throws Exception {
        ModelAndView modelAndView = new ModelAndView("login/sso-login");
        LoginModel loginModel = loginService.ssoLogin(token);
        modelAndView.addObject("sso", loginModel);
        return modelAndView;
    }

}
