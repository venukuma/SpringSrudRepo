package venu.ractise.spring.rest.dao;

import java.util.List;

import venu.ractise.spring.rest.entity.Employee;


public interface EmpoyeeDao {
	
	public int insertEmployee(Employee emp);
	public List<Employee> getEmployee();
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int empId);

}
