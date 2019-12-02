package com.employeeManagement.empDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.beans.Employee;
import com.employeeManagement.DAO.ConnectionDAO;
import com.employeeManagement.DAO.EmployeeDAO;
import com.employeeManagement.exceptions.IdNotFoundException;

public class EmployeeDAOImpl implements EmployeeDAO {
	Scanner scanner;
	static Connection connection;
	static Logger logger = Logger.getLogger(EmployeeDAO.class);
	Employee employee = new Employee();

	@Override
	public void addEmployeeToDB(Employee employee) {
		

		connection = ConnectionDAO.openConnection();
		System.out.println("Connection is   " + connection);
		String insertQuery = "Insert into Users values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		System.out.println("works");
		try {
			statement = connection.prepareStatement(insertQuery);
			System.out.println(statement + "   Statement  ");
			PropertyConfigurator.configure("log4j.properties");
			// PreparedStatement statement = null;
				

			// statement = connection.prepareStatement(insertQuery);
			// System.out.println("Statement is " + statement);

			statement.setString(1, employee.getFirstName());

			statement.setString(2, employee.getLastName());

			statement.setInt(3, employee.getId());

			statement.setString(4, employee.getAddress());

			statement.setLong(5, employee.getPhoneNo());

			statement.setString(6, employee.getGender());

			statement.setString(7, employee.getStatus());

			statement.setInt(8, employee.getSalary());

			statement.setString(9, employee.getUserName());

			statement.setString(10, employee.getPassword());

			System.out.println("58");
			statement.execute();
			System.out.println("59");
			connection.commit();
				logger.info("Inserted Sucessfully");
		} catch (SQLException e) {
			 logger.error(e.getMessage());

		} finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				logger.info("database closed");

			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}

	}

	@Override
	public void deleteEmployeeToDB(Employee employee) {
		// TODO Auto-generated method stub

		connection = ConnectionDAO.openConnection();
		String deleteQuery = "delete from Users where id=?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(deleteQuery);
			System.out.println("enter employee ID to delete data: \n");
			PropertyConfigurator.configure("log4j.properties");
			int pid = employee.getId();
			statement.setInt(1, pid);
			statement.execute();
			connection.commit();

			System.out.println("deleted!");
			logger.info("deleted sucessfully");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				logger.info("database closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}

	}

	@Override
	public void updateEmployeeToDB(Employee employee) {
		// TODO Auto-generated method stub
		

		/*connection = ConnectionDAO.openConnection();
		String updateQuery = "Update EMPLOYEES set firstName=?,lastName=?,address=?,phoneNo=?,gender=?,status=?,salary=? where id=?";
		PreparedStatement statement = null;*/
		connection = ConnectionDAO.openConnection();
		System.out.println("Connection is   " + connection);
		PropertyConfigurator.configure("log4j.properties");
		String insertQuery = "Insert into Users values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		System.out.println("works");
		try {
			statement = connection.prepareStatement(insertQuery);
			System.out.println(statement + "   Statement  ");

			// PreparedStatement statement = null;
			
			// statement = connection.prepareStatement(insertQuery);
			// System.out.println("Statement is " + statement);

			statement.setString(1, employee.getFirstName());

			statement.setString(2, employee.getLastName());

			statement.setInt(3, employee.getId());

			statement.setString(4, employee.getAddress());

			statement.setLong(5, employee.getPhoneNo());

			statement.setString(6, employee.getGender());

			statement.setString(7, employee.getStatus());

			statement.setInt(8, employee.getSalary());

			statement.setString(9, employee.getUserName());

			statement.setString(10, employee.getPassword());

			System.out.println("58");
			statement.execute();
			System.out.println("59");
			connection.commit();
			 logger.info("Inserted Sucessfully");
		} catch (SQLException e) {
			 logger.error(e.getMessage());

		} finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				logger.info("database closed");

			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}

	}

	@Override
	public Employee displayEmployeeToDB(Employee employee) throws IdNotFoundException {


		
		PreparedStatement statement = null;
		Employee user = new Employee();

		try {
			connection = ConnectionDAO.openConnection();
			statement = connection.prepareStatement("select * from Users where id=?");
			System.out.println("enter the ID of the employee whose data is to be displayed: ");
			PropertyConfigurator.configure("log4j.properties");
			int pid = employee.getId();
			statement.setInt(1, pid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				String firstname = rs.getString(1);
				String lastname = rs.getString(2);
				int id = rs.getInt(3);
				String address = rs.getString(4);
				int phoneNo = rs.getInt(5);
				String gender = rs.getString(6);
				String status = rs.getString(7);
				int salary = rs.getInt(8);
				

				
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setId(id);
				user.setAddress(address);
				user.setPhoneNo(phoneNo);
				user.setGender(gender);
				user.setStatus(status);
				user.setSalary(salary);

				
				
			
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				logger.info("database closed");

			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
			

		logger.info("showing data by ID");
	}
		return user;

	}
}