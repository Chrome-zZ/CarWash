package org.example.carWash.service;

import org.example.carWash.model.Role;
import org.example.carWash.model.Status;
import org.example.carWash.model.User;
import org.example.carWash.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    public User add(String username) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword("$2y$12$MejzLHfbZL0XNt0OUOes4e6LNeskKB0X90x9Wo33ccwg3Hh.xpPsG");
        newUser.setAutomobile("Some car");
        newUser.setRole(Role.USER);
        newUser.setStatus(Status.ACTIVE);
        return userRepo.save(newUser);
    }
}
