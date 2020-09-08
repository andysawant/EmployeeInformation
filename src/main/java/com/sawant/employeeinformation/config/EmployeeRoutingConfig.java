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
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Slf4j
@Configuration
public class EmployeeRoutingConfig {

    @Value("${welcome.url}")
    private String welcomeUrl;

    @Value("${get.all.employees.url}")
    private String getAllEmployees;

    @Value("${get.employees.by.id.url}")
    private String getEmployeeById;

    @Value("${add.employees.url}")
    private String addEmployee;

    @Value("${update.employees.url}")
    private String updateEmployee;

    @Value("${delete.employees.url}")
    private String deleteEmployee;

    @Bean
    public RouterFunction<ServerResponse> welcome(EmployeeService employeeService){
        return RouterFunctions.route(GET(welcomeUrl), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Welcome"));
        });
    }

    @Bean
    public RouterFunction<ServerResponse> getAllEmployees(EmployeeService employeeService){
        return RouterFunctions.route(GET(getAllEmployees), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Get All Employees"));
        });
    }

    @Bean
    public RouterFunction<ServerResponse> getEmployeeById(EmployeeService employeeService){
        return RouterFunctions.route(GET(getEmployeeById), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Get Employee by Id"));
        });
    }

    @Bean
    public RouterFunction<ServerResponse> addEmployee(EmployeeService employeeService){
        return RouterFunctions.route(POST(addEmployee), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Add Employee"));
        });
    }

    @Bean
    public RouterFunction<ServerResponse> updateEmployee(EmployeeService employeeService){
        return RouterFunctions.route(PUT(updateEmployee), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Update Employee"));
        });
    }

    @Bean
    public RouterFunction<ServerResponse> deleteEmployee(EmployeeService employeeService){
        return RouterFunctions.route(DELETE(deleteEmployee), request ->{
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromValue("Delete Employee"));
        });
    }

}
