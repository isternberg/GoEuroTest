package com.goeuro;

import com.goeuro.convertors.ToCSVConvertor;
import com.goeuro.entities.GoEuroData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan("validation")
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static final String BASE_PATH = "http://localhost:8080/";
	public static final String JSON = ".json";
	public static final String WRONG_INPUT = "No resource exists for the argument you've typed in.";
	public static final String INVALID_ARGS_COUNT = "Please use exactly one program argument.";

	@Autowired
	InputValidator inputValidator;

	public static void main(String args[]) {
			SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!inputValidator.inputOK(args))
			terminate(INVALID_ARGS_COUNT);
		String city= args[0];
		RestTemplate restTemplate = new RestTemplate();
		GoEuroData data = null;
		try{
			data = restTemplate.
				getForObject(BASE_PATH + city + JSON, GoEuroData.class);
		}catch(HttpClientErrorException e){
			terminate(WRONG_INPUT);
		}
		List<GoEuroData> foo = new ArrayList<>();
		foo.add(data);
		ToCSVConvertor.writeToCSV(foo);
	}

	private void terminate(String message) {
		System.out.println(message);
		System.exit(0);
	}
}
