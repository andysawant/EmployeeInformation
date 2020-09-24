package com.sawant.employeeinformation.service;

import com.sawant.employeeinformation.model.Employee;
import com.sawant.employeeinformation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long empId) {
        Employee emp = employeeRepository.findById(empId).get();
        return emp;
    }

}
