package com.dc.sql;

import java.util.List;
import java.util.Calendar;


import com.dc.sql.Controller.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SqlConnectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		//SpringApplication.run(SqlConnectionApplication.class, args);
		SpringApplication app = new SpringApplication(SqlConnectionApplication.class);
		app.run(args);
	}
	//@Scheduled(initialDelay = 1000, fixedRate = 10000)
	// "0 0 * * * *" = the top of every hour of every day.
	// "*/10 * * * * *" = every ten seconds.
	// "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
	// "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
	// "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
	// "0 0 0 25 12 ?" = every Christmas Day at midnight
	@Scheduled(cron = "0 0/58 14 * * *")
	public void select() {
		String sql = "SELECT payid,term,code FROM oper with(nolock)";
		List<Customer> customers = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Customer.class));
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		customers.forEach(System.out :: println);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
	}


}
