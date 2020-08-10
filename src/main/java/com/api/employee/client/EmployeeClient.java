package com.api.employee.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.api.employee.dto.Employee;
import com.api.employee.dto.EmployeeList;
import static java.util.Arrays.asList;
import java.util.List;

/**
 * Application that shows how to use Lists with RestTemplate.
 */
public class EmployeeClient {
    public static void main(String[] args) {
        EmployeeClient employeeClient = new EmployeeClient();

        System.out.println("Calling GET for entity using arrays");
        employeeClient.getForEntityEmployeesAsArray();
        
        System.out.println("Calling GET using ParameterizedTypeReference");
        employeeClient.getAllEmployeesUsingParameterizedTypeReference();

//        System.out.println("Calling GET using wrapper class");
//        employeeClient.getAllEmployeesUsingWrapperClass();
    }

    public EmployeeClient() {

    }

    public Employee[] getForEntityEmployeesAsArray() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Employee[]> response =
                restTemplate.getForEntity(
                        "https://run.mocky.io/v3/8dadb4ae-45f9-488d-8b05-696ee3b4c787",
                        Employee[].class);

        Employee[] employees = response.getBody();

        assert employees != null;
        asList(employees).forEach(System.out::println);

        return employees;

    }
    
    public List<Employee> getAllEmployeesUsingParameterizedTypeReference() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Employee>> response =
                restTemplate.exchange(
                        "https://run.mocky.io/v3/8dadb4ae-45f9-488d-8b05-696ee3b4c787",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });

        List<Employee> employees = response.getBody();

        assert employees != null;
        employees.forEach(System.out::println);

        return employees;
    }

    public EmployeeList getAllEmployeesUsingWrapperClass() {
        RestTemplate restTemplate = new RestTemplate();

        EmployeeList response =
                restTemplate.getForObject(
                        "https://run.mocky.io/v3/8dadb4ae-45f9-488d-8b05-696ee3b4c787",
                        EmployeeList.class);

        EmployeeList employees = new EmployeeList(response.getEmployees());

        return employees;
    }
}