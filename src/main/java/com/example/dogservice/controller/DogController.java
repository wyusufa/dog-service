package com.example.dogservice.controller;

import com.example.dogservice.model.entity.Breeds;
import com.example.dogservice.repository.BreedRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DogController {

    private final BreedRepository breedRepository;

    public DogController(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @GetMapping("/breeds/list/all")
    public void getAllBreedNameWithoutItsSubBreed() {
        List<Breeds> breedsList = breedRepository.findAll();

    }

    @GetMapping("/breed/{breedName}/list")
    public void getSubBreedOfBreed(@PathVariable String breedName) {

    }

    @GetMapping("/breed/{}/images")
    public void getImagesByBreed(@PathVariable String breedName) {

    }

    @GetMapping()
    public void getImagesByBreedAndItsSubBreed(@PathVariable String breedName, String subBreedName) {

    }
}
