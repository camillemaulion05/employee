package com.api.employee.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.api.employee.dto.Employee;
import com.api.employee.dto.EmployeeAssets;
import com.api.employee.dto.EmployeeAveSalary;

@Service("EmployeeListService")
public class EmployeeService
{
	@Autowired
	RestTemplate restTemplate;
	
	private final Employee[] employees;
	private final ArrayList<EmployeeAssets> employeesWithAssets;
    
	EmployeeService(Employee[] employees, EmployeeAssets[] employeesWithAssets) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee[]> response =
	            restTemplate.getForEntity(
	                    "https://run.mocky.io/v3/8dadb4ae-45f9-488d-8b05-696ee3b4c787",
	                    Employee[].class);
		
		Employee[] emps = response.getBody();
		this.employees = emps;
		
		ResponseEntity<EmployeeAssets[]> response2 =
	            restTemplate.getForEntity(
	                    "https://run.mocky.io/v3/9bdef44c-8629-414e-b5f0-52056380c2b8",
	                    EmployeeAssets[].class);
		
		EmployeeAssets[] assets = response2.getBody();
		ArrayList<EmployeeAssets> newAssets= new ArrayList<EmployeeAssets>();
		for (EmployeeAssets asset : assets) {
			for (Employee emp : emps) {
				if(asset.getId().equalsIgnoreCase(emp.getId())) {
					asset.setRole(emp.getRole());
					newAssets.add(asset);
				}
			}
		}
		
		this.employeesWithAssets = newAssets;
	}
		
    public Employee[] getAllEmployees() {
    	return employees;
    }
    
    public ArrayList<EmployeeAssets> getAllEmployeeAssets() {
    	return employeesWithAssets;
    }
    
	public ArrayList<Employee> getEmployeesByGender(String gender) {
		ArrayList<Employee> newEmployee= new ArrayList<Employee>();
		for (Employee employee : employees) {
			if (employee.getGender().equalsIgnoreCase(gender)) {
				newEmployee.add(employee);
			}
		}
		return newEmployee;
	}
	
	public ArrayList<EmployeeAssets> getEmployeesByAsset(String asset) {
		ArrayList<EmployeeAssets> newEmployee= new ArrayList<EmployeeAssets>();
		for (EmployeeAssets employee : employeesWithAssets) {
			if (employee.getAssets().contains(asset)) {
				newEmployee.add(employee);
			}
		}
		return newEmployee;
	}
	
	public EmployeeAveSalary getAveSalaryByGender(String gender) {
		EmployeeAveSalary average = new EmployeeAveSalary();
		int salary = 0, ave = 0;
		for (Employee employee : employees) {
			if (employee.getGender().equalsIgnoreCase(gender)) {
				salary += Integer.parseInt(employee.getSalary());
			}
		}
		ave = (salary/employees.length);
		average.setAverage(Integer.toString(ave));
		return average;
	}
}