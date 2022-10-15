package com.company.employee_payroll.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.company.employee_payroll.model.Employee;
import com.company.employee_payroll.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController
@EnableWebMvc
@RequestMapping("/api/v1")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	
	
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
	@PutMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

}