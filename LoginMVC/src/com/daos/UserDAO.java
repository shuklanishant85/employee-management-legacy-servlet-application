package com.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.Employee;
import com.employeeManagement.DAO.ConnectionDAO;

// building db layer , it is DAO , part of model
public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static Employee login(Employee bean) {
		// preparing some objects for connection
		Statement stmt = null;
		// username & password created through bean getter
		String username = bean.getUserName();
		String password = bean.getPassword();
		// search query to find out for specific user
		String searchQuery = "select * from Users where userName='" + username + "' AND password='" + password + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your are " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		try { // connect to DB
			currentCon = ConnectionDAO.openConnection();
			System.out.println("Connection is " + currentCon);
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			System.out.println("Resultset is " + rs);
			boolean more = rs.next();
			System.out.println("Resultset boolean is" + more);
			// if user does not exist set the isValid
			// variable more to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} // if user exists set the isValid variable to true
			else if (more) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				System.out.println("Welcome " + firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
			// some exception handling
		} catch (SQLException sqlEx) {
			System.out.println("Log In failed: DB Exception has occurred! " + sqlEx);
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		// Free the database resources
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {

				}
				currentCon = null;
			}
		}
		return bean;
	}
}
