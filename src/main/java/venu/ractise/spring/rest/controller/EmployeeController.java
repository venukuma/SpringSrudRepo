package venu.ractise.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import venu.ractise.spring.rest.entity.Employee;
import venu.ractise.spring.rest.entity.EmployeeResponse;
import venu.ractise.spring.rest.entity.RestUriConstants;
import venu.ractise.spring.rest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	EmployeeResponse responce;
	
	  @RequestMapping(value=RestUriConstants.SAVE_EMPLOYEE,method = RequestMethod.POST)
	  public EmployeeResponse createEmployee(@RequestBody Employee employee) {
		  responce = empService.inserEmployees(employee);
		  return responce;
	  
	  }
	  
	  @RequestMapping(value = RestUriConstants.GET_EMPLOYEE,method=RequestMethod.GET)
	  public EmployeeResponse getEmployees() {
		  responce = empService.selectEmployee();
		  return responce;
	  }
	  
	  @RequestMapping(value = RestUriConstants.UPDATE_EMPLOYEE,method=RequestMethod.POST)
	  public EmployeeResponse updateEmployee(@RequestBody Employee employee) {
		  responce = empService.updateEmployee(employee);
		  return responce;
	  
	  }
	  @RequestMapping(value = RestUriConstants.DELETE_EMPLOYEE,method=RequestMethod.DELETE)
	  public EmployeeResponse updateEmployee(@PathVariable int empId) {
		  responce = empService.deleteEmployee(empId);
		  return responce;
	  
	  }
	 

}
