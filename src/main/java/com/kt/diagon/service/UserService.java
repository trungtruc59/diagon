package com.kt.diagon.service;

import com.kt.diagon.models.CusUserDetail;
import com.kt.diagon.models.Roles;
import com.kt.diagon.models.User;
import com.kt.diagon.repository.RoleRepository;
import com.kt.diagon.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(user.toString());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return CusUserDetail.create(user);
    }
}
