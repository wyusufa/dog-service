package com.example.dogservice.repository;

import com.example.dogservice.model.entity.Breeds;
import com.example.dogservice.model.entity.DogImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogImageRepository extends JpaRepository<DogImages, Integer> {
    List<DogImages> findDogImagesByBreeds(Breeds breeds);

    List<DogImages> findBySubBreedsId(int id);
}
