package com.dc.sql;

import java.util.List;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.net.ssl.SSLException;

//import static com.dc.sql.client.Client.createWebClient;

@SpringBootApplication
@EnableScheduling
public class SqlConnectionApplication implements CommandLineRunner {

	@Value("${proxy.url}")
	private String proxyUrl;
	@Value("${proxy.buffer-size:10000000}")
	private int proxyBufferSize;

	public static void main(String[] args) {
		SpringApplication.run(SqlConnectionApplication.class, args);
	}
	//@Scheduled(initialDelay = 1000, fixedRate = 10000)
	// "0 0 * * * *" = the top of every hour of every day.
	// "*/10 * * * * *" = every ten seconds.
	// "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
	// "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
	// "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
	// "0 0 0 25 12 ?" = every Christmas Day at midnight
	//
	@Scheduled(cron = "0 0/23 21 * * *")
	public void updateTaxiOlu4aID() throws SSLException {
		//createWebClient(proxyUrl, proxyBufferSize).get();
				//.uri(PathINQUIRY_MESSAGE)
				//.contentType(MediaType.APPLICATION_JSON)
				//.body(BodyInserters.fromValue(request))
				//.header("UPI-JWS",getupijws.getContent() )
				//.retrieve()
				//.bodyToMono(String.class)
				//.timeout(Duration.ofMillis(60_000));
		//String sql = "SELECT payid,term,code FROM oper;";
		//List<Customer> customers = jdbcTemplate.query(sql,
		//		BeanPropertyRowMapper.newInstance(Customer.class));
		//writeToCSV(customers);
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		//customers.forEach(System.out :: println);
	}

	/*@Scheduled(cron = "0 0/40 15 * * *")
	public void select() {
		String sql = "SELECT payid,term,code FROM oper;";
		List<Customer> customers = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Customer.class));
		//writeToCSV(customers);
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		customers.forEach(System.out :: println);
	}*/

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
	}

	/*public static void writeToCSV(List<Customer> objectList) {
		String CSV_SEPARATOR = ",";
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("results.csv"), "UTF-8"));
			for (Customer objectDetails : objectList) {
				StringBuffer oneLine = new StringBuffer();
				Iterator it = objectDetails.values().iterator();

				while (it.hasNext()) {
					Object value = it.next();

					if(value !=null){
						oneLine.append(value.toString());
					}

					if (it.hasNext()) {
						oneLine.append(CSV_SEPARATOR);
					}
				}
				bw.write(oneLine.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}*/
}
