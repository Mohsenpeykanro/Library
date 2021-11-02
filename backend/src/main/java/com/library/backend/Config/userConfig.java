package com.library.backend.Config;

import com.library.backend.Repository.userRepository;
import com.library.backend.Service.userService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class userConfig {
    @Bean
    CommandLineRunner userCommandLineRunner(userRepository userRepository){
        return args -> {

        };
    }
}
