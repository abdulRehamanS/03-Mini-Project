package com.Abdul.MiniProject.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CountryMaster")
public class CountryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer countryId;
    private String countryName;
}
