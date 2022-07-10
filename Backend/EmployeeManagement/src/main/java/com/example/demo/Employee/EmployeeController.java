package com.example.demo.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello this is employee management system";
		
	}
	//Method to list all employees
	//(list) operation
	@CrossOrigin
	@RequestMapping("/employee")
	public List<Employee> getEmployee(){
		return employeeService.getAllEmployee();
		
		
	}
	@CrossOrigin
	@RequestMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployee(id);
		
	}
	
	//add operation
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/employee")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
		
	}
	
	//update operation
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT,value="/employee/{id}")
	public void updateEmployee(@RequestBody Employee emp,@PathVariable String id) {
		employeeService.updateEmployee(emp, id);
		
	}
	//delete
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE,value="/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
	}
	

}
