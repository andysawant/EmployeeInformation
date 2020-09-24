package com.sawant.employeeinformation.repository;

import com.sawant.employeeinformation.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    public List<Employee> findAll();
    public Optional<Employee> findById(Long empId);
}
