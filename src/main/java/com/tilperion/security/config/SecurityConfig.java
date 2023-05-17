package com.tilperion.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/demo").authenticated()
                .anyRequest().permitAll();

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetails user1 = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
