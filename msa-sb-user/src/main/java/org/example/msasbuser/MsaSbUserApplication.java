package org.example.msasbuser;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsaSbUserApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        String dbHost = dotenv.get("JWT_SECRET_KEY");
        SpringApplication.run(MsaSbUserApplication.class, args);
    }

}
