import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RESTAPIService } from './restapiservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui-app';
  employeeid = ""
  employeename = ""
  employeedesig = ""
  employeedoj = ""
  employeesalary = ""

  empid=""
  empname=""
  empdesignation=""
  empdoj=""
  empsalary=""



  empDetails = null as any;
  employeeToUpdate = {
    id:"",
    name:"",
    designation:"",
    doj:"",
    salary:""
  }
  constructor(private service: RESTAPIService,private router:Router){
    this.getEmployees();


  }

  ngOnInit():void{
  }

  saveEmployee(){
    let employeeDetail = {id:this.employeeid, name:this.employeename,designation:this.employeedesig,doj:this.employeedoj,salary:this.employeesalary};
    this.service.postEmployee(employeeDetail).subscribe({
      error:(err)=>{console.error(err)},
      complete:()=>{console.log('success');

      this.getEmployees();
    }
    });
  }
  getEmployees(){
    this.service.getEmployee().subscribe(
      (Response)=>{
        console.log(Response);
        this.empDetails = Response;

      },
      (err)=>{
        console.log(err);
      }
    )
  }
  deleteEmployee(employee:any){
    this.service.deleteEmployee(employee.id).subscribe(
      (Response)=>{
        console.log(Response);

      },
      (err)=>{console.log(err);}
    )
  }

  updateEmployee(employee:any){
    let empUpdate = {id:this.empid, name:this.empname,designation:this.empdesignation,doj:this.empdoj,salary:this.empsalary};

    this.service.updateEmployee(empUpdate.id).subscribe({
      error:(err)=>{console.error(err)},
      complete:()=>{console.log('success');
    }
  });
  }
  UpdateEmployee(id:number){
    this.router.navigate(['update-employee',id]);
  }

}
