package com.employeeManagement.servicesImpl;

import com.beans.Employee;
import com.employeeManagement.DAO.EmployeeDAO;
import com.employeeManagement.empDAOImpl.EmployeeDAOImpl;
import com.employeeManagement.exceptions.IdNotFoundException;
import com.employeeManagement.service.EmployeeServices;

public class EmployeeServicesImpl implements EmployeeServices {

	EmployeeDAO empDAO = new EmployeeDAOImpl();

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empDAO.addEmployeeToDB(employee);

	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empDAO.deleteEmployeeToDB(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empDAO.updateEmployeeToDB(employee);

	}

	@Override
	public Employee displayEmployee(Employee employee) throws IdNotFoundException {
		return empDAO.displayEmployeeToDB(employee);

	}

}