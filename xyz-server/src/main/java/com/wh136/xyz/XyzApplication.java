package com.wh136.xyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@MapperScan(value = "com.wh136.**.mapper")
public class XyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzApplication.class, args);
	}

}
