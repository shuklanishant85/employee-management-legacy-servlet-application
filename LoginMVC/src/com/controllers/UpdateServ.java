package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Employee;
import com.employeeManagement.service.EmployeeServices;
import com.employeeManagement.servicesImpl.EmployeeServicesImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 'user' bean created
			Employee user = new Employee();
			// setters called

			user.setFirstName(request.getParameter("fn"));
			user.setLastName(request.getParameter("ln"));
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setAddress(request.getParameter("ad"));
			user.setPhoneNo(Long.parseLong(request.getParameter("ph")));
			user.setGender(request.getParameter("ge"));
			user.setStatus(request.getParameter("st"));
			user.setSalary(Integer.parseInt(request.getParameter("sal")));

		
			EmployeeServices empDAO = new EmployeeServicesImpl();
			empDAO.updateEmployee(user);
			response.sendRedirect("thankyou.jsp");
		} catch (Throwable theException) {
			System.out.println(theException);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
