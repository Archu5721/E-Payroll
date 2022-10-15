import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { map } from 'rxjs/operators';
import { ApiService } from '../service/api.service';
import { EmployeeModel } from './employee.model';
import { EmployeeData } from './employeedata.model';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  employeeModelObj:EmployeeModel=new EmployeeModel();
  public loginForm!: FormGroup;
  fetchedEmployees:EmployeeData[]=[];
  url='';
  constructor(private http:HttpClient,private formBuilder:FormBuilder,private api:ApiService) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      emp_name:['',Validators.required],
      date_of_joining:['',Validators.required],
      email:['',Validators.required],
      designation:['',Validators.required],
      gender:['',Validators.required],
      age:['',Validators.required],
      salary:['',Validators.required]
  })
     this.fetchEmployees();
  }

  onAddEmployee(employeeData: { emp_name:string,date_of_joining:string,email:string,designation:string,salary:number,gender:string,age:number }, form: NgForm) {
    this.http.post("http://localhost:8080/Employees/addemployee", employeeData).subscribe((responseData) => {
      // console.log(responseData);
      alert("Employee added Successfully!!");
      form.reset();
      this.fetchEmployees();
    });
  }

  fetchEmployees() {
    this.http
      .get("http://localhost:8080/Employees/employeelist")
      .pipe(
        map((responseData) => {
          const empArray: EmployeeData[] = [];
          for (const key in responseData) {
            var x = { ...responseData[key] };
            empArray.push(x);
          }
          return empArray;
        })
      )
      .subscribe((emps) => {
        this.fetchedEmployees = emps;
      });
  }

  DeleteEmployee(id: number) {
    this.http.delete("http://localhost:8080/Employees/deleteemployee"+ '/' + id).subscribe((response) => {
      console.log('Employee deleted: ' + response);
      alert("Employee Deleted!!");
      this.fetchEmployees();
    });
  }

  onEdit(emp:any){
    this.employeeModelObj.id=emp.id;
    this.loginForm.controls['emp_name'].setValue(emp.emp_name);
    this.loginForm.controls['date_of_joining'].setValue(emp.date_of_joining);
    this.loginForm.controls['email'].setValue(emp.email);
    this.loginForm.controls['designation'].setValue(emp.designation);
    this.loginForm.controls['salary'].setValue(emp.salary);
    this.loginForm.controls['gender'].setValue(emp.gender);
    this.loginForm.controls['age'].setValue(emp.age);
  }

  updateEmployee(){
    this.employeeModelObj.emp_name=this.loginForm.value.emp_name;
    this.employeeModelObj.date_of_joining=this.loginForm.value.date_of_joining;
    this.employeeModelObj.email=this.loginForm.value.email;
    this.employeeModelObj.designation=this.loginForm.value.designation;
    this.employeeModelObj.gender=this.loginForm.value.gender;
    this.employeeModelObj.salary=this.loginForm.value.salary;
    this.employeeModelObj.age=this.loginForm.value.age;


    this.api.UpdateEmployee(this.employeeModelObj,this.employeeModelObj.id)
    .subscribe(res=>{
      alert("Updated SuccessFully!!");
      this.loginForm.reset();
      this.fetchEmployees();
    })
  }


}
