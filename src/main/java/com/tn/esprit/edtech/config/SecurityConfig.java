package com.tn.esprit.edtech.config;

import com.tn.esprit.edtech.filters.AuthenticationFilter;
import com.tn.esprit.edtech.filters.AuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.OPTIONS, "/api/login/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/login/**", "/api/logout/**", "/api/users/**", "/api/matieres/**", "/api/enseignant/**", "/api/modules/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/users/**", "/api/enseignant/**", "/api/matieres/**", "/api/modules/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**", "/api/matieres/**", "/api/modules/**","/api/enseignant/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/**", "/api/modules/**", "/api/enseignant/**", "/api/matieres/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilter(new AuthenticationFilter(authenticationManagerBean()))
                .addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}




