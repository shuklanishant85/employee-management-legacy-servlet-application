package com.employeeManagement.service;

import com.beans.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;

public interface EmployeeServices {
	void addEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Employee displayEmployee(Employee employee) throws IdNotFoundException;

}
