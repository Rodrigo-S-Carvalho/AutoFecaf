package br.com.veiculos_fecaf_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner inicializacao () {

        return args -> {

            System.out.println("Servidor inicializado com sucesso!");


        };


    }

}
