package pt.ua.tqs.air_polution_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AirPolutionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirPolutionProjectApplication.class, args);
	}

}
