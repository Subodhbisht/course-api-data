package io.course.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"io.course.springboot.security","io.course.springbootstarter"})
@SpringBootApplication
public class CourseApiApp {

	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
	}

}
