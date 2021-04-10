package com.example.uppgift2.lager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;


@Configuration
public class LagerConfig {
    @Bean
    CommandLineRunner commandLineRunner(LagerRepository repository){
     return args ->{

         Lager bord = new Lager(
               "Bord",
                 "123455",
                 "Möbler",
                 22

         );
         Lager stol = new Lager(
                 "stol",
                 "1234ewe55",
                 "Möbler",
                 22






         );
         Lager lampa = new Lager(
                 "Lampa",
                 "1234342355",
                 "Lampor",
                 22






         );
       repository.saveAll(List.of(bord,stol,lampa)
       );
     };

    }
}
