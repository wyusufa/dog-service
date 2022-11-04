package com.example.dogservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubBreeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private Breeds breeds;

    @OneToMany(mappedBy = "subBreeds", cascade = CascadeType.ALL)
    private List<DogImages> dogImages = new ArrayList<>();

}
