package ru.booknetwork.ssn.data.analysis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "ru.booknetwork.ssn.data.analysis")
public class SsnDataAnalysisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsnDataAnalysisApplication.class, args);
	}

	@Bean
	public SessionFactory sessionFactory() {
		return getSessionFactory();
	}

	private SessionFactory getSessionFactory() {
		final StandardServiceRegistry registry = buildRegistry();
		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			throw new RuntimeException(e);
		}
	}

	private StandardServiceRegistry buildRegistry() {
		return new StandardServiceRegistryBuilder()
				.configure()
				.build();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
