package App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class ClimberApplication {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(ClimberApplication.class);
        app.run(args);
    }
}
