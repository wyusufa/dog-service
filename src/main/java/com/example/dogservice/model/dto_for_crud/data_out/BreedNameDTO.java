package com.example.dogservice.model.dto_for_crud.data_out;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BreedNameDTO {
    private Map<String,List<String>> message;
    private String status;
}
