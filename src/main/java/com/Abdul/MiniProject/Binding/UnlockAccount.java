package com.Abdul.MiniProject.Binding;


import lombok.Data;

@Data
public class UnlockAccount {

    private  String email;
    private String temPassword;
    private String newPassword;
    private String confirmPassword;



}
