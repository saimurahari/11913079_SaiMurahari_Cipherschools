package com.example.demo.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	List<Employee> employee = new ArrayList<>(Arrays.asList(
			new Employee("A001","Sudharshan Rao", "Junior Developer","07.04.2021","35000"),
			new Employee("A002","Sunil Reddy", "Java Developer","08.02.2020","30000"),
			new Employee("A003","Sai Murahari", "Front end Developer","09.01.2019","55000"),
			new Employee("A004","Keerthi", "SDE","09.04.2022","45000")
			
			));
	public List<Employee> getAllEmployee(){
		ArrayList<Employee> employeearr = new ArrayList<>();
		
		employeeRepository.findAll()
		.forEach(employeearr::add);
		
		return employeearr;
		
		
	}
	public Optional<Employee> getEmployee(String id) {
		return employeeRepository.findById(id);
		
		
	}
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
		
	}
	public void updateEmployee(Employee emp, String id) {
		employeeRepository.save(emp);
		
	}
	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);
	}

}
