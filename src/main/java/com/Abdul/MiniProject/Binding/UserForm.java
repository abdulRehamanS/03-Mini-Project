package com.Abdul.MiniProject.Binding;

import lombok.Data;

import java.time.LocalDate;


@Data
public class UserForm {

    private String fName;
    private String LName;
    private String eMail;
    private Long mobile;
    private LocalDate dob;
    private String gender;
    private Integer countryId;
    private Integer stateId;
    private Integer cityId;
}
