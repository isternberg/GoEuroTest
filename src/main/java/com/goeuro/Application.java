package com.goeuro;

import com.goeuro.appUtils.AppUtils;
import com.goeuro.convertors.ToCSVConverter;
import com.goeuro.data.APIConsumer;
import com.goeuro.entities.GoEuroData;
import com.goeuro.validation.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static final String BASE_PATH = "http://api.goeuro.com/api/v2/position/suggest/en/";
	public static final String INVALID_ARGS_COUNT = "\nNope!\nPlease use exactly one program argument.";
	public static final String NO_RESULT = "\nNope!\nNo results for the argument you've used.";
	private static final String CSV_CREATED = "\nYES!\noutput.csv has been created in same directory as JAR-File.";

	@Autowired
	InputValidator inputValidator;

	@Autowired
	APIConsumer apiConsumer;

	@Autowired
	AppUtils utils;

	public static void main(String args[]) {
			SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!inputValidator.inputOK(args)){
			log.error("Terminating due to wrong user input");
			utils.terminate(INVALID_ARGS_COUNT);
		}
		String city= args[0];
		List<GoEuroData> responseBody = apiConsumer.consume(city);
		if (responseBody.isEmpty()){
			utils.terminate(NO_RESULT);
		}
		ToCSVConverter.writeToCSV(responseBody);
		log.info("csv successfully created for city: " + city);
		utils.terminate(CSV_CREATED);
	}
}