package com.srijan.employee_management.config;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails hr = User.withUsername("hr")
                .password(encoder.encode("hrpass1"))
                .roles("HR")
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("userpass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(hr, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // APIs > disable CSRF for Postman usage
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // allow H2 console
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/employees/**").hasAnyRole("HR", "USER")
                        .requestMatchers("/api/v1/employees/**").hasRole("HR") // POST, PUT, DELETE require HR
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
