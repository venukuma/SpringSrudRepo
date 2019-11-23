package venu.ractise.spring.rest.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import venu.ractise.spring.rest.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmpoyeeDao {
	
	private static final String sql = "insert into employee (EMID,EMPNAME,EMPAGE,EMPHIREDATE,EMPMAIL) values(?,?,?,SYSDATE,?)";
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int insertEmployee(Employee emp) {

		Object[] empl = new Object[] { emp.getEmpId(), emp.getEmpName(), emp.getAge(),
				emp.getEmail() };

		logger.debug("EMployee details before inserting into db {}", empl);

		int row = template.update(sql, empl);

		return row;
	}
	
	

}
