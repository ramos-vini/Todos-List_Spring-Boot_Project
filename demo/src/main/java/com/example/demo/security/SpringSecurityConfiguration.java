package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username, String password){
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        UserDetails userDetails1 = createNewUser("vini", "mito");
        UserDetails userDetails2 = createNewUser("nana", "banana");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // All URLs are protected
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // Login Form is shown for unauthorized requests
        http.formLogin(Customizer.withDefaults());

        // CSRF is Disabled
        http.csrf().disable();

        // Frames are Disabled
        http.headers().frameOptions().disable();

        return http.build();
    }

}
