package com.kt.diagon.models;

import com.kt.diagon.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CusUserDetail implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean is_active;

    private Collection<? extends GrantedAuthority> authorities;

    public CusUserDetail() {}

    public CusUserDetail(Long id, String username, String password, boolean isActive, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.is_active = isActive;
        this.authorities = authorities;
    }

    public static CusUserDetail create(User user) {
        List<Roles> roles = new ArrayList<>();
        roles.add(user.getRole());

        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

        return new CusUserDetail(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                !user.isLock(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true; // Customize as needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Customize as needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Customize as needed
    }

    @Override
    public boolean isEnabled() {
        return is_active;
    }
}
