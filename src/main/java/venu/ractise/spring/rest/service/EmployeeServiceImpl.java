package venu.ractise.spring.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venu.ractise.spring.rest.dao.EmpoyeeDao;
import venu.ractise.spring.rest.entity.Employee;
import venu.ractise.spring.rest.entity.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmpoyeeDao dao;
	EmployeeResponse response;

	@Override
	public EmployeeResponse inserEmployees(Employee employee) {
		response = new EmployeeResponse();
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

	@Override
	public EmployeeResponse selectEmployee() {
		response = new EmployeeResponse();
		List<Employee> employees = dao.getEmployee();
		logger.info("List of employees {}",employees);
		if (employees != null && !employees.isEmpty()) {
			response.setStatus("Sucess");
			response.setStatusCode(200);
			response.setEmpList(employees);
		} else {
			response.setStatus("Failed");
			response.setStatusCode(201);
		}
		return response;
	}

	@Override
	public EmployeeResponse updateEmployee(Employee employee) {
		response = new EmployeeResponse();
		int rows = dao.updateEmployee(employee);
		if (rows > 0) {
			response.setStatus("Sucess");
			response.setStatusCode(200);
		} else {
			response.setStatus("Failed");
			response.setStatusCode(201);
		}

		return response;
	}

	@Override
	public EmployeeResponse deleteEmployee(int id) {
		response = new EmployeeResponse();
		int rows = dao.deleteEmployee(id);
		if (rows > 0) {
			response.setStatus("Sucess");
			response.setStatusCode(200);
		} else {
			response.setStatus("Failed");
			response.setStatusCode(201);
		}

		return response;
	}

}
