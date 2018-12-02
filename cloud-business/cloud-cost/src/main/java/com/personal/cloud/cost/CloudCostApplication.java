package com.personal.cloud.cost;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@MapperScan(basePackages = "com.personal.cloud.*.mapper")
public class CloudCostApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudCostApplication.class, args);
	}

	@RequestMapping("/")
	void home(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}
}
