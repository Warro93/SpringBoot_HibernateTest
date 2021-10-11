package com.hibernate;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateTestApplication {
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("Warro93Darksider");
		dataSourceBuilder.url("jdbc:mysql://127.0.0.1:3306/palestra1");
		return dataSourceBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateTestApplication.class, args);
	}

}
