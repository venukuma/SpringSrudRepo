package venu.ractise.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venu.ractise.spring.rest.dao.EmpoyeeDao;
import venu.ractise.spring.rest.entity.Employee;
import venu.ractise.spring.rest.entity.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmpoyeeDao dao;

	@Override
	public EmployeeResponse inserEmployees(Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		int row = dao.insertEmployee(employee);
		if (row > 0) {
			response.setStatus("Sucess");
			response.setStatusCode(200);
		} else {
			response.setStatus("Failed");
			response.setStatusCode(201);
		}

		return response;
	}

	
	
	
	

}
