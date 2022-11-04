package com.example.dogservice.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MigrateDataFromDogAPI implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("migrate data..");
    }
}
