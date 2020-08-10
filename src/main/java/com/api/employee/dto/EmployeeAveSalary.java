package com.api.employee.dto;

public class EmployeeAveSalary {
	private String average;
	
	public EmployeeAveSalary() {}

	public EmployeeAveSalary(String average) {
		super();
		this.average = average;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "EmployeeAveSalary [average=" + average + "]";
	}
	
	
}
