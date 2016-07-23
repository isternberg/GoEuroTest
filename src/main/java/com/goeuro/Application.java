package com.goeuro;

import com.goeuro.convertors.GoEuroDataListToCSV;
import com.goeuro.entities.GoEuroData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static final String BASE_PATH = "http://localhost:8080/";
	public static final String JSON = ".json";

	public static void main(String args[]) {
			SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		GoEuroData data = restTemplate.
				getForObject(BASE_PATH + "berlin" + JSON, GoEuroData.class);
		List<GoEuroData> foo = new ArrayList<>();
		foo.add(data);
		GoEuroDataListToCSV.writeToCSV(foo);
		log.debug("Amen!");
	}
}
