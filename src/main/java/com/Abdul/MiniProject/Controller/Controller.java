package com.Abdul.MiniProject.Controller;


import com.Abdul.MiniProject.Binding.LoginForm;
import com.Abdul.MiniProject.Binding.UnlockAccount;
import com.Abdul.MiniProject.Binding.UserForm;
import com.Abdul.MiniProject.Service.InterfaceServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {


    @Autowired
    InterfaceServcie interfaceServcie;


    public Controller(InterfaceServcie interfaceServcie) {
        this.interfaceServcie = interfaceServcie;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        String status = interfaceServcie.login(loginForm);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @GetMapping(value = "/countries")
    public Map<Integer, String> loadCounties() {
        return interfaceServcie.getCountries();
    }


    @GetMapping(value = "/states/{countryId}")
    public Map<Integer, String> loadstates(@PathVariable Integer countryId) {
        return interfaceServcie.getStates(countryId);
    }


    @GetMapping(value = "/cities/{stateId}")
    public Map<Integer, String> loadcities(@PathVariable Integer stateId) {
        return interfaceServcie.getCities(stateId);
    }

    // for email-check
    @GetMapping(value = "/email/{email}")
    public String emailCheck(@PathVariable String email) {
        return interfaceServcie.checkEmail(email);
    }

    // for register form
    @PostMapping(value = "/user")
    public ResponseEntity<String> userRegister(@RequestBody UserForm userForm) {
        String status = interfaceServcie.registerUser(userForm);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    //for unlocking-account
    @PostMapping(value = "unlock")
    public ResponseEntity<String> unlock(@RequestBody UnlockAccount unlockAccount) {
        String status = interfaceServcie.unlockAccount(unlockAccount);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    // for forget password
    @GetMapping(value = "/forgotpwd/{email}")
    public ResponseEntity<String> forgotpwd(@PathVariable String email) {
        String status = interfaceServcie.forgotPwd(email);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


}
