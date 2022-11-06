package com.example.dogservice.model.dto_for_crud.data_out;

import lombok.Data;

import java.util.List;

@Data
public class DogImageDTO {
    private List<String> message;
    private String status;
}
