package com.Abdul.MiniProject.Entity;


import jakarta.persistence.*;
import lombok.Data;

import javax.xml.transform.sax.SAXResult;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "UserDetails")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String fName;
    private String LName;
    private String email;
    private Long mobile;
    private LocalDate dob;
    private String gender;
    private Integer countryId;
    private Integer stateId;
    private Integer cityId;
    private String accountStatus;
    private String accountPassword;

}
