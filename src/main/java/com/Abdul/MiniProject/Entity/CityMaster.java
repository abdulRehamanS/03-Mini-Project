package com.Abdul.MiniProject.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CityMaster")
public class CityMaster {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer cityId;
     private String  cityName;
     private Integer stateId;
}
