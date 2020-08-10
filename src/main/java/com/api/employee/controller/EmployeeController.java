package com.api.employee.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.employee.dto.Employee;
import com.api.employee.dto.EmployeeAssets;
import com.api.employee.dto.EmployeeAveSalary;
import com.api.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{	
	@Autowired
    private EmployeeService employeeService;
  
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Employee[]> getEmployeeList()
    {
    	Employee[] employees = employeeService.getAllEmployees();
    	return new ResponseEntity<Employee[]>(employees, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/assets")
    public ResponseEntity<ArrayList<EmployeeAssets>> getAllEmployeesWithAssets()
    {
    	ArrayList<EmployeeAssets> employees = employeeService.getAllEmployeeAssets();
    	return new ResponseEntity<ArrayList<EmployeeAssets>>(employees, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/gender/{gender}")
	public ResponseEntity<ArrayList<Employee>> getEmployeesByGender(@PathVariable("gender") String gender) {
    	ArrayList<Employee> list = employeeService.getEmployeesByGender(gender);
		return new ResponseEntity<ArrayList<Employee>>(list, HttpStatus.OK);
	}
    
    @RequestMapping(method = RequestMethod.GET, path = "/assets/{asset}")
	public ResponseEntity<ArrayList<EmployeeAssets>> getEmployeesByAsset(@PathVariable("asset") String asset) {
    	ArrayList<EmployeeAssets> list = employeeService.getEmployeesByAsset(asset);
		return new ResponseEntity<ArrayList<EmployeeAssets>>(list, HttpStatus.OK);
	}
    
    @RequestMapping(method = RequestMethod.GET, path = "/averageSalary/gender/{gender}")
	public ResponseEntity<EmployeeAveSalary> getAveSalaryByGender(@PathVariable("gender") String gender) {
    	EmployeeAveSalary list = employeeService.getAveSalaryByGender(gender);
		return new ResponseEntity<EmployeeAveSalary>(list, HttpStatus.OK);
	}
}