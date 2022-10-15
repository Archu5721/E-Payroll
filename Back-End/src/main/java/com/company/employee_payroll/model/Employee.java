package com.company.employee_payroll.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "emp_name")
	private String emp_name;

	@Column(name = "date_of_joining")
	private String date_of_joining;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private int age;

	@Column(name = "designation")
	private String designation;

	@Column(name = "email")
	private String email;

	@Column(name = "salary")
	private String salary;

	public Employee() {

	}

	public Employee(long id, String emp_name, String date_of_joining, String gender, int age, String designation,
			String email, String salary) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.date_of_joining = date_of_joining;
		this.gender = gender;
		this.age = age;
		this.designation = designation;
		this.email = email;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}