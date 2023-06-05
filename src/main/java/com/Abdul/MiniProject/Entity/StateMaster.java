package com.Abdul.MiniProject.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "StateMaster")
public class StateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stateId;
    private String stateName;
    private Integer countryId ;
}
