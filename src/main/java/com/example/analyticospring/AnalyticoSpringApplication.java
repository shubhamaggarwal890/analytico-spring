package com.example.analyticospring;

import com.example.analyticospring.entity.User;
import com.example.analyticospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnalyticoSpringApplication {

    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AnalyticoSpringApplication.class, args);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public ApplicationRunner initializer() {
        return args -> {
            try {
                User user = userService.getByEmailId("shubham@analytico.com");
                if (user == null) {
                    userService.signup("Shubham", "Aggarwal", "shubham@analytico.com",
                            "1677");
                }
            } catch (Exception error) {
                System.out.println(error.getLocalizedMessage());
            }
        };
    }
}
