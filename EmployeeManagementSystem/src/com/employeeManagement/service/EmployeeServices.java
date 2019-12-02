package com.employeeManagement.service;

import com.employeeManagement.bean.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;

public interface EmployeeServices {
	void addEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void displayEmployee(Employee employee) throws IdNotFoundException;

}
