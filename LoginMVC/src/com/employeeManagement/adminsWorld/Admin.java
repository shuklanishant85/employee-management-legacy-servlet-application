
package com.employeeManagement.adminsWorld;

import java.util.Scanner;

import com.beans.Employee;
import com.employeeManagement.exceptions.IdNotFoundException;
import com.employeeManagement.service.EmployeeServices;
import com.employeeManagement.servicesImpl.EmployeeServicesImpl;

public class Admin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username = "sapient";
		String password = "sapient";

		System.out.println("Log in:");
		System.out.println("username: ");
		username = sc.next();
		sc.nextLine();

		System.out.println("password:  ");
		password = sc.next();
		System.out.println("\n");

		// users check = new users(username, password);

		if (username.equals(username) && password.equals(password)) {
			System.out.println("You are logged in");

			System.out.println(
					"\n" + "\n" + "\n" + "\n" + "\n" + "\t  *******************************************************"
							+ "\n" + "\t  **                                                   **" + "\n"
							+ "\t  **                   You Are In                      **" + "\n"
							+ "\t  **                                                   **" + "\n"
							+ "\t  **                  Employee Menu                    **" + "\n"
							+ "\t  **                                                   **" + "\n"
							+ "\t  *******************************************************" + "\n" + "\n");

			System.out.println("\t\t  What do you want to do for employee  " + "\n"
					+ "\t\t  ===================================" + "\n" + "\n" + "\n\n\t 1  =>  Add employee  "
					+ "\n\n\t 2  =>  Delete Employee  " + "\n\n\t 3  =>  Update employee  "
					+ "\n\n\t 4  =>  Display employee  " + "\n\n\t 5  =>  Employee menu Exit \n"
					+ "\t===     ------------------ " + "\n" + "\t\t\t\tYou Select : ");

		}
		Employee employee = new Employee();

		EmployeeServices empDAO = new EmployeeServicesImpl();

		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			System.out.println("Enter employee details:");
			empDAO.addEmployee(employee);
			break;
		case 2:
			System.out.println("\n");
			empDAO.deleteEmployee(employee);

			break;
		case 3:
			System.out.println("Update employee details:");
			empDAO.updateEmployee(null);
			break;
		case 4:
			System.out.println("Diplay employee details:");
			try {
				empDAO.displayEmployee(employee);
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("nothing to display..... exiting");
			break;
		}
		sc.close();
	}

}
