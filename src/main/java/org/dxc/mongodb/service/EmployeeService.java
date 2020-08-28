package org.dxc.mongodb.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.dxc.mongodb.model.Employee;

public interface EmployeeService {

	boolean saveemployee(Employee employee);

	Collection<Employee> getAllEmployees();

	Optional<Employee> getEmployee(Double employeeid);

	void deleteEmployee(Double employeeid);

	void updateEmployee(Employee employee, Double employeeid);

}
