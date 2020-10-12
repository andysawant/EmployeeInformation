package com.sawant.employeeinformation.service;

import com.sawant.employeeinformation.model.Employee;
import com.sawant.employeeinformation.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Service
public class EmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;
    private  static String ID="id";

    public Mono<ServerResponse> getAllEmployees(ServerRequest request) {
        Iterable<Employee> employeeIterable=employeeRepository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(fromValue(employeeIterable));
    }

    public Mono<ServerResponse> getEmployeeById(ServerRequest request) {
        String empId=request.pathVariable(ID);
        Employee emp = employeeRepository.findById(Long.parseLong(empId)).get();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(fromValue(emp));
    }

    public Mono<ServerResponse> addEmployee(ServerRequest request) {
        return request.bodyToMono(Employee.class)
                .flatMap(employee -> {
                        Employee emp = employeeRepository.save(employee);
                        LOG.info("employee saver - {}",emp.toString());
                        return ServerResponse.ok().body(fromValue(emp));
                });
        }

    public Mono<ServerResponse> deleteEmployee(ServerRequest request) {
        String empId=request.pathVariable(ID);
        StringBuilder deleteResponse = new StringBuilder();
        if(employeeRepository.findById(Long.parseLong(empId)).isPresent()) {
            employeeRepository.delete(employeeRepository.findById(Long.parseLong(empId)).get());
            deleteResponse.append("Employee ID "+empId+" deleted successfully.");
        }else{
            deleteResponse.append("Employee with ID "+empId+" does not exist");
        }

        return ServerResponse.ok().contentType(TEXT_PLAIN).body(fromValue(deleteResponse));
    }

    public  Mono<ServerResponse>  updateEmployee(ServerRequest request) {
        StringBuilder updateResponse = new StringBuilder();
        return request.bodyToMono(Employee.class)
                .flatMap(employee -> {
                    if(employeeRepository.findById(employee.getId()).isPresent()) {
                        Employee emp=employeeRepository.findById(employee.getId()).get();
                        emp.setFirstName(employee.getFirstName());
                        emp.setLastName(employee.getLastName());
                        emp.setAddress(employee.getAddress());
                        emp.setGender(employee.getGender());
                        emp.setDob(employee.getDob());
                        Employee updatedEmp = employeeRepository.save(emp);
                        updateResponse.append("Employee ID "+employee.getId()+" updated successfully.");
                    }else{
                        updateResponse.append("Employee with ID "+employee.getId()+" does not exist");
                    }
                    return ServerResponse.ok().body(fromValue(updateResponse));
                });
    }
}
