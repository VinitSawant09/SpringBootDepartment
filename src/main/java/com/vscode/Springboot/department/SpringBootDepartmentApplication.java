package com.vscode.Springboot.department;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Department API",version="1.0"))
public class SpringBootDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDepartmentApplication.class, args);
	}

}
