package com.company.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.company.employee.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{

	

}
