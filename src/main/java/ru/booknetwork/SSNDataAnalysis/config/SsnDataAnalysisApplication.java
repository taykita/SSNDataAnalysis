package ru.booknetwork.SSNDataAnalysis.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContext;

@SpringBootApplication(scanBasePackages = "ru.booknetwork.SSNDataAnalysis")
public class SsnDataAnalysisApplication {
	@Autowired
	public SsnDataAnalysisApplication(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	private final HibernateUtil hibernateUtil;

	public static void main(String[] args) {
		SpringApplication.run(SsnDataAnalysisApplication.class, args);
	}

	@Bean
	public SessionFactory sessionFactory() {
		return hibernateUtil.getSessionFactory();
	}

}
