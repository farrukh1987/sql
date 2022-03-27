package com.dc.sql;

import com.dc.sql.database.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SqlConnectionApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void select() {
		String sql = "SELECT payid,term,code FROM oper WHERE INPUTDATE LIKE '220323224755%';";
		List<Customer> customers = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Customer.class));
		//writeToCSV(customers);
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		customers.forEach(System.out :: println);
		assertNotNull(customers);
	}


}
