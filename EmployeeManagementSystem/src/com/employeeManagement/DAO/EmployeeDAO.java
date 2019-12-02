package com.employeeManagement.DAO;

import com.employeeManagement.bean.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;

public interface EmployeeDAO {
	void addEmployeeToDB(Employee employee);

	void deleteEmployeeToDB(Employee employee);

	void updateEmployeeToDB(Employee employee);

	void displayEmployeeToDB(Employee employee) throws IdNotFoundException;
}
