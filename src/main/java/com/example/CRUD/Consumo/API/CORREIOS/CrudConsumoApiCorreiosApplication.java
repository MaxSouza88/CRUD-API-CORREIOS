package com.example.CRUD.Consumo.API.CORREIOS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CrudConsumoApiCorreiosApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudConsumoApiCorreiosApplication.class, args);
	}
}


