package com.surbhikalra.healinghearts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // You can replace this with your own service to pull users from a database
        var userDetailsManager = new InMemoryUserDetailsManager();

        var user = User.withUsername("user")
                .password(new BCryptPasswordEncoder().encode("password"))
                .roles("USER")
                .build();

        userDetailsManager.createUser(user);

        return userDetailsManager;
    }
}
