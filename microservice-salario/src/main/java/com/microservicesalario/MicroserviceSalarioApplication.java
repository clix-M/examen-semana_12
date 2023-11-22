package com.microservicesalario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceSalarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSalarioApplication.class, args);
	}

}
