package org.example.carWash.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.carWash.model.User;
import org.example.carWash.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Api
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('users:write')")
    @ApiOperation("Показать всех пользователей")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    @ApiOperation("Показать пользователя по id")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }
}