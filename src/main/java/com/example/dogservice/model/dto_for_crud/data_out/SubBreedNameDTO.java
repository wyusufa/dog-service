package com.example.dogservice.model.dto_for_crud.data_out;

import lombok.Data;

import java.util.List;

@Data
public class SubBreedNameDTO {
    private List<String> message;
    private String status;
}
