package com.sawant.employeeinformation.repository;

import com.sawant.employeeinformation.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
