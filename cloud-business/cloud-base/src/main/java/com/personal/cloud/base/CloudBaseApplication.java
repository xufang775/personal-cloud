package com.personal.cloud.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@RestController
@SpringBootApplication
@MapperScan("com.personal.cloud.base.mapper")
public class CloudBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudBaseApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "redirect:swagger-ui.html";
	}
}
