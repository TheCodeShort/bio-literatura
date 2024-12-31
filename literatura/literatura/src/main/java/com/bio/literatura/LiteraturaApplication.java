package com.bio.literatura;

import com.bio.literatura.principla.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	Principal principal = new Principal();


}
