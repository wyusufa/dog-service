package com.example.dogservice.repository;

import com.example.dogservice.model.entity.Breeds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breeds, Integer> {
    Breeds findBreedsByName(String name);
}