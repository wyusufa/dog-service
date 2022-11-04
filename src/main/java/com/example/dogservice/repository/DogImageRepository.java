package com.example.dogservice.repository;

import com.example.dogservice.model.entity.DogImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogImageRepository extends JpaRepository<DogImages, Integer> {
}
