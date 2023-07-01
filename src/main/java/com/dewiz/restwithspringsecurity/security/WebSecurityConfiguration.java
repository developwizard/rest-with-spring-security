package com.dewiz.restwithspringsecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
    private final AccountAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers(HttpMethod.POST, "/api/accounts/**").permitAll()
                                .anyRequest().hasAnyRole("USER", "ADMIN")
                ).httpBasic(Customizer.withDefaults())
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
