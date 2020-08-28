package org.dxc.mongodb.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.dxc.mongodb.model.Employee;
import org.dxc.mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping("/saveemployee")
	public HttpStatus saveEmployee(@RequestBody Employee employee) {

		boolean status = employeeService.saveemployee(employee);

		return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	
	@GetMapping("/getemployees")
	public Collection<Employee> getEmployees() {
		
		Collection<Employee> employees = employeeService.getAllEmployees();
		System.out.println("---------"+employees);
		return employees;
	}
	
	
	@GetMapping("/getemployee")
	public Optional<Employee> getEmployee(@RequestParam("id") Double employeeid) {

		return employeeService.getEmployee(employeeid);
	}
	@DeleteMapping("/deleteemployee")
	public void deleteEmployee(@RequestParam("id") Double employeeid) {

		employeeService.deleteEmployee(employeeid);
	}
	@PutMapping("/updateemployee")
	public void updateEmployee(@RequestBody Employee employee, @RequestParam("id") Double                                                                             employeeid) {

		employeeService.updateEmployee(employee, employeeid);
	}

	

}
