package com.api.employee.dto;

public class Employee {
		
	private String id;
	private String name;
	private String role;
	private String gender;
	private String salary;
	private String company;
	
	public Employee() {}

	public Employee(String id, String name, String role, String gender, String salary, String company) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.gender = gender;
		this.salary = salary;
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", gender=" + gender + ", salary=" + salary
				+ ", company=" + company + "]";
	}
}
