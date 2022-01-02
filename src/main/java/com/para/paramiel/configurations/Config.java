package com.para.paramiel.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 */

@Configuration
public class Config {

    /**
     * @return BCryptPasswordEncoder is for password encoding and password decoding or validate.
     * BCryptPasswordEncoder is using the BCrypt algorithm.
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

}
