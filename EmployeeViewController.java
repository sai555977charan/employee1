package com.example.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.Model.Employee;
import com.example.employee.ModelResponse.EmployeeViewResponse;
import com.example.employee.Service.EmployeeViewService;

@RestController
public class EmployeeViewController {
	@Autowired
	EmployeeViewService employeeViewService;

	@GetMapping(value = "/getemployee/{id}")
	public EmployeeViewResponse view(@PathVariable int id) {
		EmployeeViewResponse employeeViewResponse = new EmployeeViewResponse();
		List<Employee> employee = employeeViewService.getEmployee(id);
		String name=null;
		for(Employee details:employee)
		{
			name=details.getName();
		}
		
		if (name!=null) {
			employeeViewResponse.setStatusId("200");
			employeeViewResponse.setMessage("EMPLOYEE DETAILS DISPLAYED SUCCESSFULLY");
			employeeViewResponse.setEmployee(employee);
			return employeeViewResponse;
		} else
		{
			employeeViewResponse.setStatusId("200");
		employeeViewResponse.setMessage("EMPLOYEE DETAILS Not found check employee id");
		
		return employeeViewResponse;
		}
	}

}
