package com.personal.cloud.cost;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan(basePackages = "com.personal.cloud.*.mapper")
public class CloudCostApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudCostApplication.class, args);
	}
}
