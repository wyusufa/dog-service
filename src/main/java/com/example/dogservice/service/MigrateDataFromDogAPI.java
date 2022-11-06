package com.example.dogservice.service;

import com.example.dogservice.model.dto_for_data_migration.BreedsDTO;
import com.example.dogservice.model.dto_for_data_migration.DogImagesDTO;
import com.example.dogservice.model.dto_for_data_migration.SubBreedsDTO;
import com.example.dogservice.model.entity.Breeds;
import com.example.dogservice.model.entity.DogImages;
import com.example.dogservice.model.entity.SubBreeds;
import com.example.dogservice.repository.BreedRepository;
import com.example.dogservice.repository.DogImageRepository;
import com.example.dogservice.repository.SubBreedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

/***
 * migrate data from dog api to H2 database
 */
@Service
@Slf4j
public class MigrateDataFromDogAPI  {

    private final RestTemplate restTemplate;
    private final BreedRepository breedRepository;
    private final SubBreedRepository subBreedRepository;
    private final DogImageRepository dogImageRepository;

    public MigrateDataFromDogAPI(RestTemplate restTemplate, BreedRepository breedRepository, SubBreedRepository subBreedRepository, DogImageRepository dogImageRepository) {
        this.restTemplate = restTemplate;
        this.breedRepository = breedRepository;
        this.subBreedRepository = subBreedRepository;
        this.dogImageRepository = dogImageRepository;
    }

    public void run()  {
        log.info("data migration from Dog API to H2 DB start");
        log.info("please wait...");
        migrateDataFromDogAPItoDB();
        log.info("data migration from Dog API to H2 DB finish");
        log.info("Dog Service is ready");
    }

    private void migrateDataFromDogAPItoDB() {
        BreedsDTO breedsDTO = restTemplate.getForObject("https://dog.ceo/api/breeds/list/all", BreedsDTO.class);
        assert breedsDTO != null;
        LinkedHashMap<Object, Object> breedMap = breedsDTO.getMessage();
        for (Object breedKey : breedMap.keySet()) {
            String breedName = breedKey.toString();
            Breeds breed = saveBreedToDB(breedName);
            migrateSubBreed(breedName, breed);
            log.info("migrating '" + breedName + "' and its sub-breed + images from Dog API to DB");
        }
    }

    private Breeds saveBreedToDB(String breedName) {
        var breed = new Breeds();
        breed.setName(breedName);
        breedRepository.save(breed);
        return breed;
    }

    private void migrateSubBreed(String breedName, Breeds breed) {
        String subBreedsURL = "https://dog.ceo/api/breed/" + breedName + "/list";
        SubBreedsDTO subBreedsDTO = restTemplate.getForObject(subBreedsURL, SubBreedsDTO.class);
        assert subBreedsDTO != null;
        var subBreedList = subBreedsDTO.getMessage();
        if (!subBreedList.isEmpty()){
            for (Object sub : subBreedList) {
                String subBreedName = sub.toString();
                var subBreed = new SubBreeds();
                subBreed.setName(subBreedName);
                subBreed.setBreeds(breed);
                subBreedRepository.save(subBreed);
                migrateDogImageByBreedAndItsSubBreed(breedName, breed, subBreedName, subBreed);
            }
        }
        else {
            migrateDogImageByBreedThatDoNotHaveSubBreed(breedName, breed);
        }
    }

    private void migrateDogImageByBreedAndItsSubBreed(String breedName, Breeds breed, String subBreedName, SubBreeds subBreeds) {
        String dogImagesUrl = "https://dog.ceo/api/breed/" + breedName + "/"+ subBreedName +"/images";
        var dogImagesList = getDogImagesUrlLists(dogImagesUrl);
        for (Object img : dogImagesList) {
            String imgUrl = img.toString();
            var dogImage = new DogImages();
            dogImage.setBreeds(breed);
            dogImage.setSubBreeds(subBreeds);
            dogImage.setUrl(imgUrl);
            dogImageRepository.save(dogImage);
        }
    }

    private void migrateDogImageByBreedThatDoNotHaveSubBreed(String breedName, Breeds breed) {
        String dogImagesUrl = "https://dog.ceo/api/breed/" + breedName + "/images";
        var dogImagesList = getDogImagesUrlLists(dogImagesUrl);
        for (Object img : dogImagesList) {
            String imgUrl = img.toString();
            var dogImage = new DogImages();
            dogImage.setBreeds(breed);
            dogImage.setUrl(imgUrl);
            dogImageRepository.save(dogImage);
        }
    }

    private List<Object> getDogImagesUrlLists(String dogImagesUrl) {
        DogImagesDTO dogImagesDTO = restTemplate.getForObject(dogImagesUrl, DogImagesDTO.class);
        assert dogImagesDTO != null;
        return dogImagesDTO.getMessage();
    }

}
