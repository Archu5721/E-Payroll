package com.company.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.employee.model.Employee;
import com.company.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepo emprepo;
	
	public Employee saveEmployee(Employee emp){
		return emprepo.save(emp);
	}
	
	 public Iterable<Employee> getEmployees(){
		return emprepo.findAll();
	}
	 
	public  Employee UpdateEmployee(Employee emp){
		 return emprepo.save(emp);
	 }
	
//	 public void DeleteEmployee(Integer id){
//		 emprepo.delete(id);
//	}
}
