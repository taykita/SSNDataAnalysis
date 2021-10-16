package ru.booknetwork.ssn.data.analysis.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "ru.booknetwork.ssn.data.analysis")
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
