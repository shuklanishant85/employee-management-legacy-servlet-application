package com.employeeManagement.bean;

public class Employee {
	private String name;
	private int id;
	String address;
	long phoneNo;
	String sex;
	String status;
	int salary;

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "The employee " + name + " has the following details as entered\n" + "id = " + id + "\n address = "
				+ address + "\n phone = " + "phoneNo = " + phoneNo + "\n sex = " + sex + "\n status = " + status
				+ "\n salary = " + salary;
	}
}
