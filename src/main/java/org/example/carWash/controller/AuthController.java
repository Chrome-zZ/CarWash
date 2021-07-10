package org.example.carWash.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@Api
public class AuthController {

    @GetMapping("/login")
    @ApiOperation("Страница авторизации")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    @ApiOperation("Страница об успешной авторизации")
    public String getSuccessPage() {
        return "success";
    }
}
