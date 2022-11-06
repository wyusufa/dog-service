package com.example.dogservice.repository;

import com.example.dogservice.model.entity.Breeds;
import com.example.dogservice.model.entity.SubBreeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubBreedRepository extends JpaRepository<SubBreeds,Integer> {

    List<SubBreeds> findSubBreedsByBreeds(Breeds breeds);
    List<SubBreeds> findByNameAndBreeds(String name, Breeds breeds);




}
