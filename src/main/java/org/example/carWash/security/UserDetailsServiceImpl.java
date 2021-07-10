package org.example.carWash.security;

import org.example.carWash.model.User;
import org.example.carWash.repos.UserRepo;
import org.example.carWash.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserService userService;

    public UserDetailsServiceImpl(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean checkUser = userRepo.findByUsername(username).isPresent();
        if (checkUser) {
            User user = userRepo.findByUsername(username).get();/*orElseThrow(() ->
                    new UsernameNotFoundException("User doesn't exists"));*/
//        User user = userRepo.findByUsername(username).orElse(userService.add(username));
//            return SecurityUser.fromUser(user);
            return SecurityUser.fromUser(user);
        } else {
            User newUser = userService.add(username);
            return SecurityUser.fromUser(newUser);
        }
    }
}