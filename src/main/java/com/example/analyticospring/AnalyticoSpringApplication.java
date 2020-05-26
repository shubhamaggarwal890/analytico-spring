package com.example.analyticospring;

import com.example.analyticospring.entity.User;
import com.example.analyticospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

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
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        String url = System.getenv("DATABASE_HOST");
        if(url !=null){
            dataSourceBuilder.url("jdbc:mysql://analytico-mysql:3306/analytico?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
        }else{
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/analytico");
        }
        dataSourceBuilder.username("analytico");
        dataSourceBuilder.password("1677");
        return dataSourceBuilder.build();
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
