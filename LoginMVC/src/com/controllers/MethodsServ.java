package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;
import com.employeeManagement.service.EmployeeServices;
import com.employeeManagement.servicesImpl.EmployeeServicesImpl;
/**
 * Servlet implementation class Methods
 */
public class MethodsServ extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Employee employee = new Employee();
    	EmployeeServices empDAO = new EmployeeServicesImpl();
		
		
        if (request.getParameter("ae") != null) {
            empDAO.addEmployee(employee);
        } else if (request.getParameter("de") != null) {
            empDAO.deleteEmployee(employee);
        } else if (request.getParameter("ue") != null) {
            empDAO.updateEmployee(null);
        } else if (request.getParameter("dise") != null) {
        	try {
				empDAO.displayEmployee(employee);
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (request.getParameter("exit") != null) {
        	System.out.println("nothing to display..... exiting");
        }


    }

}
