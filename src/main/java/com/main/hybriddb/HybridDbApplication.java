package com.main.hybriddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.spark.sql.SparkSession;

@SpringBootApplication
public class HybridDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HybridDbApplication.class, args);
	}

}
