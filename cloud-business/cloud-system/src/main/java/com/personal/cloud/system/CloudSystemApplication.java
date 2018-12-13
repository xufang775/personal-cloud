package com.personal.cloud.system;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@ApiIgnore
@RestController
@EnableSwagger2Doc
@SpringBootApplication
//@ComponentScan(basePackages = {"com.personal.cloud.base.util","com.personal.cloud.system.service.impl"})
@MapperScan(basePackages ={"com.personal.common.mapper", "com.personal.cloud.*.mapper"})
public class CloudSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSystemApplication.class, args);
	}

	@RequestMapping("/")
	void home(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}
}
