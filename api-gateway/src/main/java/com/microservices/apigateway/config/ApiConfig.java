package com.microservices.apigateway.config;

import com.microservices.apigateway.filter.SessionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public SessionFilter sessionFilter(){
        return new SessionFilter();
    }
}
