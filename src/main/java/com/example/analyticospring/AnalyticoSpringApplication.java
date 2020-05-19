package com.example.analyticospring;

import com.example.analyticospring.service.TwitterService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AnalyticoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticoSpringApplication.class, args);
	}

}
