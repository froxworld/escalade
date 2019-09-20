package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClimberApplication {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(ClimberApplication.class);
        app.run(args);
    }
}
