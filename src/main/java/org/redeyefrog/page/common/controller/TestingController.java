package org.redeyefrog.page.common.controller;

import org.redeyefrog.page.common.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @Autowired
    private TestingService testingService;

    @GetMapping("/testing")
    public void testing() {
        testingService.testing();
    }

}
