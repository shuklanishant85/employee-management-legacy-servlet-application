package com.employeeManagement.DAO;

import com.beans.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;

public interface EmployeeDAO {
	void addEmployeeToDB(Employee employee);

	void deleteEmployeeToDB(Employee employee);

	void updateEmployeeToDB(Employee employee);

	Employee displayEmployeeToDB(Employee employee) throws IdNotFoundException;
}
