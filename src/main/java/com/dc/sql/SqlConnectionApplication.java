package com.dc.sql;

import java.util.List;

import com.dc.sql.Controller.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlConnectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SqlConnectionApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT Account FROM Account";
		List<Customer> customers = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Customer.class));

		customers.forEach(System.out :: println);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
}
