package com.sawant.employeeinformation.config;

import com.sawant.employeeinformation.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Slf4j
@Configuration
public class EmployeeRoutingConfig {

    @Value("${welcome.url}")
    private String welcomeUrl;

    @Bean
    public RouterFunction<ServerResponse> welcome(EmployeeService employeeService){
        return RouterFunctions.route(GET(welcomeUrl), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Welcome"));
        });
    }
}
