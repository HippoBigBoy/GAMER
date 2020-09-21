package za.co.dinoko.assignment.ayeshaMatwadia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class AyeshaMatwadiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyeshaMatwadiaApplication.class, args);
	}
}
