package venu.ractise.spring.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import venu.ractise.spring.rest.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmpoyeeDao {

	private static final String insert = "insert into employee (EMID,EMPNAME,EMPAGE,EMPHIREDATE,EMPMAIL) values(?,?,?,SYSDATE,?)";
	private static final String slect = "select * from employee";
	private static final String update = "update employee set EMPNAME=?,EMPAGE=?,EMPMAIL=? where EMID=?";
	private static final String delete = "delete from employee where EMID=?";

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private JdbcTemplate template;

	@Override
	public int insertEmployee(Employee emp) {

		Object[] empl = new Object[] { emp.getEmpId(), emp.getEmpName(), emp.getAge(), emp.getEmail() };

		logger.debug("EMployee details before inserting into db {}", empl);

		int row = template.update(insert, empl);

		return row;
	}

	@Override
	public List<Employee> getEmployee() {

		List<Employee> employees = template.query(slect, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setAge(rs.getInt(3));
				employee.setHireDate(rs.getDate(4));
				employee.setEmail(rs.getString(5));

				return employee;
			}

		});

		return employees;
	}

	@Override
	public int updateEmployee(Employee employee) {
		Object[] employees = new Object[] { employee.getEmpName(), employee.getAge(), employee.getEmail(),
				employee.getEmpId() };

		int rows = template.update(update, employees);

		return rows;
	}

	@Override
	public int deleteEmployee(int empId) {
		int row = template.update(delete, empId);
		return row;
	}


}
