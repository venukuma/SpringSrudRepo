package venu.ractise.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import venu.ractise.spring.rest.entity.Employee;
import venu.ractise.spring.rest.entity.EmployeeResponse;
import venu.ractise.spring.rest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	EmployeeResponse responce;
	
	  @RequestMapping(value="/saveEmployee",method = RequestMethod.POST)
	  public EmployeeResponse createEmployee(@RequestBody Employee employee) {
		  responce = empService.inserEmployees(employee);
		  return responce;
	  
	  }
	 

}
