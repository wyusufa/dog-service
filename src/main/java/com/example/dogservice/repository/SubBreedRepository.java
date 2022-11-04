package com.example.dogservice.repository;

import com.example.dogservice.model.entity.SubBreeds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubBreedRepository extends JpaRepository<SubBreeds,Integer> {
}
