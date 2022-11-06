package com.example.dogservice.controller;

import com.example.dogservice.service.MigrateDataFromDogAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataMigrationController {

    private final MigrateDataFromDogAPI migrateDataFromDogAPI;

    public DataMigrationController(MigrateDataFromDogAPI migrateDataFromDogAPI) {
        this.migrateDataFromDogAPI = migrateDataFromDogAPI;
    }

    @GetMapping("/migrate-from-dog-api")
    public void migrateData() {
        migrateDataFromDogAPI.run();
    }
}
