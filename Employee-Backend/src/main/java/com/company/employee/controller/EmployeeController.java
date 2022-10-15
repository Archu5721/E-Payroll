package com.company.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employee.model.Employee;
import com.company.employee.repository.EmployeeRepo;
import com.company.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Employees")
public class EmployeeController {
	
//	@Autowired
//	Employee emp = new Employee();
	@Autowired
	EmployeeRepo emprepo;
	
	@Autowired
	EmployeeService empservice = new EmployeeService();
	
	@GetMapping("/employeelist")
	public Iterable<Employee> getEmployees(){
		return empservice.getEmployees();
	}
	
	@PostMapping("/addemployee")
	public Employee AddEmployee(@RequestBody Employee emp){
		return empservice.saveEmployee(emp);
	}
	
	@PutMapping("/updateemployee")
	public Employee UpdateEmployee(@RequestBody Employee emp){
		return empservice.UpdateEmployee(emp);
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public void deleteemployee(@PathVariable("id") Integer id) {
		emprepo.deleteById(id);
	}
	
}
