package com.example.portfolio.service.core.user.service;

import com.example.portfolio.service.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       var user =  userRepository.findByEmail(username)
               .orElseThrow(()->new UsernameNotFoundException("User not found"));

       return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
