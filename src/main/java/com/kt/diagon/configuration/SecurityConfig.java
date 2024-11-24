package com.kt.diagon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth-> auth.requestMatchers("/", "/assets/**").permitAll()
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin.defaultSuccessUrl("/admin", true).failureUrl("/login").permitAll())
//                .formLogin(formRegister -> formRegister.loginPage("/register").defaultSuccessUrl("/login", true).permitAll().failureUrl("/register"))
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
