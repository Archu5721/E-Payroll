import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm!: FormGroup;
  
  submitted=false;
  constructor( private formBuilder: FormBuilder,private http: HttpClient , private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      username : [''],
      password : ['']

  })
   }
  onSubmit() {
    this.submitted = true;
    this.login();
   
  }
  login(){
    this.http.get<any>("http://localhost:8081/Employees/employeelist").subscribe(res=>{
      const emp = res.find((a:any)=>{
        return a.email === this.loginForm.value.username && a.password === this.loginForm.value.password      
      });
      if(emp){
        alert("Login Success,Click Ok to continue!!");
        this.loginForm.reset();
        this.router.navigate(['emphome']);
      }else{
        alert("Try Again!!");
      }
    })
  }
  gotoRegister(){
    this.router.navigate(['register']);

  }

}

