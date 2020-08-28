package org.dxc.mongodb.service;

import java.util.Collection;
import java.util.Optional;

import org.dxc.mongodb.model.Employee;
import org.dxc.mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Collection<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public boolean saveemployee(Employee employee) {
		
		boolean status = employeeRepository.save(employee)!= null;
		
		return status;
		
	}

	@Override
	public Optional<Employee> getEmployee(Double employeeid) {
		return employeeRepository.findById(employeeid);
	}

	@Override
	public void deleteEmployee(Double employeeid) {
		
		employeeRepository.deleteById(employeeid);
		
	}

	
	@Override
	public void updateEmployee(Employee employee, Double employeeid) {
		
		
		Employee updatedemp = employeeRepository.findById(employeeid).get();
		updatedemp.setFirstName(employee.getFirstName());
		updatedemp.setLastName(employee.getLastName());
		updatedemp.setJobTitle(employee.getJobTitle());
		updatedemp.setSalary(employee.getSalary());
		
		employeeRepository.save(updatedemp);
		
		
		
	}

	/*
	@Override
	public List<Book> findByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public List<Book> findByCategory(String category) {
		// TODO Auto-generated method stub
		return bookRepository.findByCategory(category);
	}
	
	@Override
	public List<Book> findByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return bookRepository.findByAuthor(authorName);
		}
		
	*/




}
