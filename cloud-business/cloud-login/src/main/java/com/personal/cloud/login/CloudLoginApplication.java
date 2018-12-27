package com.personal.cloud.login;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
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
@MapperScan(basePackages ={"com.personal.common.mapper","com.personal.cloud.login.mapper"})
//@ComponentScan(basePackages = {"com.personal.common.util"})
public class CloudLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudLoginApplication.class, args);
	}
	@RequestMapping("/")
	void home(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}
}

