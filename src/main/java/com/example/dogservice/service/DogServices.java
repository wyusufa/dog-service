package com.example.dogservice.service;

import com.example.dogservice.model.entity.Breeds;
import com.example.dogservice.model.entity.DogImages;
import com.example.dogservice.repository.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServices {

    public List<DogImages> returnOddSizeOfImages(List<DogImages> dogImages) {
        int sizes = dogImages.size();
        if (sizes == 0) return dogImages;
        if (sizes % 2 == 0) return dogImages.subList(0, sizes - 1);
        return dogImages;
    }

}
