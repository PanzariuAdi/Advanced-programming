package com.example.demo.person;

import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {

        return args -> {
            Person adi = new Person(1L, "Adi", "panzariu.adi00@gmail.com", LocalDate.of(2000, 1, 8));
            Person alex = new Person("Alex", "alex.gmail.com", LocalDate.of(2000, 5, 10));

            repository.saveAll(
                    List.of(adi, alex)
            );
        };
    }
}
