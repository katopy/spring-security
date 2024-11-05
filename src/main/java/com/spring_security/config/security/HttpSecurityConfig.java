package com.spring_security.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider daoAuthProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Method chaining
        return http
                // There's no session to protect
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessConfig -> sessConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthProvider)
                .authorizeHttpRequests(authReqConfig -> {
                    authReqConfig.requestMatchers(HttpMethod.POST, "/customers").permitAll();
                    authReqConfig.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();

                    authReqConfig.anyRequest().authenticated();
                })
                .build();

    }


}
