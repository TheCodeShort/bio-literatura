package com.bio.literatura;

import com.bio.literatura.principla.Principal;
import com.bio.literatura.repositorio.IAutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired//inyeccion de dependencias
	private IAutorRepositorio iAutorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(iAutorRepositorio);
		principal.muestraMenu();
	}
}
