package org.example.msasbuser;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsaSbUserApplication {


    public static void main(String[] args) {

        SpringApplication.run(MsaSbUserApplication.class, args);
    }


}
