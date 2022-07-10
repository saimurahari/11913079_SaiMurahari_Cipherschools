import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RESTAPIService {

  constructor(private http:HttpClient) { }
  httpOptions = {
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  };
  url="http://localhost:8080";
  postEmployee(employee:any){
    let url="http://localhost:8080/employee";
    return this.http.post(url,employee,this.httpOptions);
  }
  getEmployee(){
    let url = "http://localhost:8080/employee";
    return this.http.get(url);
  }
  deleteEmployee(id:any){
    let API = "http://localhost:8080";
    return this.http.delete(API+'/employee/'+id);
  }

  updateEmployee(employee:any){
    let API = "http://localhost:8080/employee/";
    return this.http.put(API+employee,this.httpOptions);
  }

}
