package com.spring.sigmaweb.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {
	/*@Autowired
	BCryptPasswordEncoder passwordEncoder;
*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//System.out.println("Hola mundo");
		//System.out.println(passwordEncoder.encode("5259"));
	}
}
