package com.tilperion.security.config;

import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.cors.CorsConfiguration;

import java.net.http.HttpClient;

@Configuration
public class SecurityConfig {

    @Value("${cors.methods}")
    private String corsMethods;

    @Value("${cors.headers}")
    private String corsHeaders;

    @Value("${cors.origins}")
    private String corsOrigins;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.formLogin();

        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/demo").authenticated()
                .requestMatchers("/public").permitAll()
                .requestMatchers("/users/").hasRole("admin")
                .requestMatchers("/users/add").permitAll()
                .anyRequest().authenticated();

        httpSecurity.csrf()
                .ignoringRequestMatchers("/post")
                .ignoringRequestMatchers("/users/add");

        httpSecurity.cors().configurationSource(r -> {
            CorsConfiguration c = new CorsConfiguration();

            c.addAllowedHeader(corsHeaders);
            c.addAllowedMethod(corsMethods);
            c.addAllowedOrigin(corsOrigins);

            return c;
        });

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsManager userDetailsManager() {
//        UserDetails user1 = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
