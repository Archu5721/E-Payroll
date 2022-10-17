import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Route, Router, Routes } from '@angular/router';
import { ApiService } from '../service/api.service';
import { EmployeeModel } from './employee.model';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  employeeModelObj:EmployeeModel=new EmployeeModel();
  public loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder,private http:HttpClient,private router:Router,private api:ApiService) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      username : [''],
      password : ['']
  })
}

  login(){
    this.http.get<any>("http://localhost:8081/Employees/employeelist").subscribe(res=>{
      const emp = res.find((a:any)=>{
        return a.email === this.loginForm.value.username   
      });
      if(emp){
        this.updatePassword();
        this.loginForm.reset();
        // this.router.navigate(['emphome']);
      }else{
        alert("Try Again!!");
      }
    })
  }
  updatePassword(){
    this.employeeModelObj.password=this.loginForm.value.password;

    this.api.UpdateEmployee(this.employeeModelObj,this.employeeModelObj.id)
    .subscribe(res=>{
      alert("Updated SuccessFully!!");
      this.loginForm.reset();
      // this.fetchEmployees();
    })
  }

}


