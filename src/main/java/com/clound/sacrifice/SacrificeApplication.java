package com.clound.sacrifice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.clound.sacrifice.dao")
public class SacrificeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SacrificeApplication.class, args);
	}

}
