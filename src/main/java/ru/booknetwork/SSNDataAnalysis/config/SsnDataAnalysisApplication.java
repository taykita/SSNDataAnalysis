package ru.booknetwork.SSNDataAnalysis.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.booknetwork.SSNDataAnalysis.analyzer")
public class SsnDataAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsnDataAnalysisApplication.class, args);
	}



}
