import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  onAddEmployee(employeeData: { emp_name:string,date_of_joining:string,email:string,designation:string,salary:number,gender:string,age:number,password:string }, form: NgForm) {
    this.http.post("http://localhost:8080/Employees/addemployee", employeeData).subscribe((responseData) => {
      // console.log(responseData);
      alert("Employee added Successfully!!");
      form.reset();
    });
  }

}
