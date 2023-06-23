package com.webapp.sambram;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webapp.sambram.Entities.Usr01;
import com.webapp.sambram.repositories.Usr01Repository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Usr01Repository usr01Repository;

    public CustomUserDetailsService(Usr01Repository usr01Repository) {
        this.usr01Repository = usr01Repository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
          Usr01 user = usr01Repository.findByEmail(usernameOrEmail)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with email: "+ usernameOrEmail));

        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                authorities);
    }
}