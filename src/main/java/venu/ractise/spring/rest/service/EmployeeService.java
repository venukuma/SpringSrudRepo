package venu.ractise.spring.rest.service;

import venu.ractise.spring.rest.entity.Employee;
import venu.ractise.spring.rest.entity.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse inserEmployees(Employee employee);
	public EmployeeResponse selectEmployee();
	public EmployeeResponse updateEmployee(Employee employee);
	public EmployeeResponse deleteEmployee(int id);
	

}
