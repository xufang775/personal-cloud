package com.personal.cloud.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.personal.cloud.base.mapper")
public class CloudBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudBaseApplication.class, args);
	}
}
