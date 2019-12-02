package com.employeeManagement.empDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.employeeManagement.DAO.ConnectionDAO;
import com.employeeManagement.DAO.EmployeeDAO;
import com.employeeManagement.bean.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;

public class EmployeeDAOImpl implements EmployeeDAO {
	Scanner scanner;
	static Connection connection;
	static Logger logger = Logger.getLogger(EmployeeDAO.class);

	Employee employee = new Employee();

	@Override
	public void addEmployeeToDB(Employee employee) {
		// TODO Auto-generated method stub

		connection = ConnectionDAO.openConnection();
		System.out.println("Connection is   " + connection);
		String insertQuery = "Insert into EMPLOYEES values(?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(insertQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// PreparedStatement statement = null;
		// PropertyConfigurator.configure("log4j.properties");
		try {
			// statement = connection.prepareStatement(insertQuery);
			// System.out.println("Statement is " + statement);
			System.out.println("enter employee name: \n");
			scanner = new Scanner(System.in);
			String name = scanner.next();
			employee.setName(name);
			System.out.println(employee.getName());
			statement.setString(1, employee.getName());
			System.out.println("enter employee ID: \n");
			int id = scanner.nextInt();
			employee.setId(id);
			statement.setInt(2, employee.getId());
			System.out.println("enter employee address: \n");
			String address = scanner.next();
			employee.setAddress(address);
			statement.setString(3, employee.getAddress());
			System.out.println("enter employee contactNo (10 digits only): \n");
			long phoneNo = scanner.nextLong();
			employee.setPhoneNo(phoneNo);
			statement.setLong(4, employee.getPhoneNo());
			System.out.println("enter employee sex (male/female): \n");
			String sex = scanner.next();
			employee.setSex(sex);
			statement.setString(5, employee.getSex());
			System.out.println("enter employee marital status: \n");
			String status = scanner.next();
			employee.setStatus(status);
			statement.setString(6, employee.getStatus());
			System.out.println("enter employee salary: \n");
			int salary = scanner.nextInt();
			employee.setSalary(salary);
			statement.setInt(7, employee.getSalary());
			statement.execute();
			System.out.println("employee added");
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
		String deleteQuery = "delete from EMPLOYEES where id=?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(deleteQuery);
			System.out.println("enter employee ID to delete data: \n");
			scanner = new Scanner(System.in);
			int id = scanner.nextInt();
			statement.setInt(1, id);
			statement.execute();

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

		connection = ConnectionDAO.openConnection();
		String updateQuery = "Update EMPLOYEES set name=?,address=?,phoneNo=?,sex=?,status=?,salary=? where id=?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(updateQuery);
			System.out.println("enter employee name: \n");
			scanner = new Scanner(System.in);
			String name = scanner.next();
			statement.setString(1, name);
			System.out.println("enter employee address: \n");
			String address = scanner.next();
			statement.setString(2, address);
			System.out.println("enter employee contactNo (10 digits only): \n");
			long phoneNo = scanner.nextLong();
			statement.setLong(3, phoneNo);
			System.out.println("enter employee sex (male/female): \n");
			String sex = scanner.next();
			statement.setString(4, sex);
			System.out.println("enter employee marital status: \n");
			String status = scanner.next();
			statement.setString(5, status);
			System.out.println("enter employee salary: \n");
			int salary = scanner.nextInt();
			statement.setInt(6, salary);
			System.out.println("enter employee ID: \n");
			int id = scanner.nextInt();
			statement.setInt(7, id);
			statement.execute();
			System.out.println("details updated.");

			logger.info("updated the changes sucessfully");
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
	public void displayEmployeeToDB(Employee employee) throws IdNotFoundException {
		// TODO Auto-generated method stub

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		PreparedStatement statement = null;

		try {
			connection = ConnectionDAO.openConnection();
			statement = connection.prepareStatement("select * from EMPLOYEES where id=?");
			System.out.println("enter the ID of the employee whose data is to be displayed: ");
			scanner = new Scanner(System.in);
			int pid = scanner.nextInt();
			statement.setInt(1, pid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				String name = rs.getString(1);
				int id = rs.getInt(2);
				String address = rs.getString(3);
				int phoneNo = rs.getInt(4);
				String sex = rs.getString(5);
				String status = rs.getString(6);
				int salary = rs.getInt(7);

				Employee employee2 = new Employee();
				employee2.setName(name);
				employee2.setId(id);
				employee2.setAddress(address);
				employee2.setPhoneNo(phoneNo);
				employee2.setSex(sex);
				employee2.setStatus(status);
				employee2.setSalary(salary);

				System.out.println(employee2);
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
			if (employeeList.size() == 0)
				throw new IdNotFoundException("Id not found");
		}

		logger.info("showing data by ID");
	}

}
