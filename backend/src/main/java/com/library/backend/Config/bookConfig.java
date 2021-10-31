package com.library.backend.Config;

import com.library.backend.Repository.bookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class bookConfig {

    @Bean
    CommandLineRunner bookCommandLineRunner(bookRepository bookRepository){
        return args -> {

        };
    }
}
