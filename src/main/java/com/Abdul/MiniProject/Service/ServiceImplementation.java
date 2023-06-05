package com.Abdul.MiniProject.Service;


import com.Abdul.MiniProject.Binding.LoginForm;
import com.Abdul.MiniProject.Binding.UnlockAccount;
import com.Abdul.MiniProject.Binding.UserForm;
import com.Abdul.MiniProject.Entity.CityMaster;
import com.Abdul.MiniProject.Entity.CountryMaster;
import com.Abdul.MiniProject.Entity.StateMaster;
import com.Abdul.MiniProject.Entity.UserDetails;
import com.Abdul.MiniProject.Repo.CityRepo;
import com.Abdul.MiniProject.Repo.CountryRepo;
import com.Abdul.MiniProject.Repo.StateRepo;
import com.Abdul.MiniProject.Repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class ServiceImplementation implements InterfaceServcie {
    // Auto-wiring the all the repository present in the project


    @Autowired
    CountryRepo countryRepo;
    @Autowired
    StateRepo stateRepo;
    @Autowired
    CityRepo cityRepo;
    @Autowired
    UserRepo userRepo;

    // code for Generating Password
    private static String generatePassword() {
        String text = "ABCDEFGHIJKLMNOPQURSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        int passwordlentgh = 6;
        Random random = new Random();

        for (int i = 1; i <= passwordlentgh; i++) {

            int index = random.nextInt(text.length());
            sb.append(text.charAt(index));

        }
        return sb.toString();
    }

    @Override
    public String checkEmail(String email) {
        UserDetails userDetails = userRepo.findByEmail(email);
        if (userDetails == null) {
            return "Unique";
        }
        return "Duplicate";
    }

    @Override
    public Map<Integer, String> getCountries() {
        List<CountryMaster> countries = countryRepo.findAll();
        // creating hashmap
        Map<Integer, String> countryMap = new HashMap<>();

        countries.forEach(countryMaster -> {
            countryMap.put(countryMaster.getCountryId(), countryMaster.getCountryName());
        });
        return countryMap;
    }

    @Override
    public Map<Integer, String> getStates(Integer countryId) {
        List<StateMaster> states = stateRepo.findByCountryId(countryId);

        Map<Integer, String> stateMap = new HashMap<>();

        states.forEach(StateMaster -> {
            stateMap.put(StateMaster.getStateId(),
                    StateMaster.getStateName());
        });

        return stateMap;
    }

    @Override
    public Map<Integer, String> getCities(Integer stateId) {
        List<CityMaster> cities = cityRepo.findByStateId(stateId);
        //hashmap
        Map<Integer, String> cityMap = new HashMap<>();

        cities.forEach(cityMaster -> {
            cityMap.put(cityMaster.getCityId(),
                    cityMaster.getCityName());
        });
        return cityMap;
    }

    @Override
    public String registerUser(UserForm userForm) {
        // copying binding data to entity data
        UserDetails entity = new UserDetails();

        BeanUtils.copyProperties(userForm, entity);

        // Generating and setting random password
        entity.setAccountPassword(generatePassword());

        //set account status as locked
        entity.setAccountStatus("Locked");

        userRepo.save(entity);


        // TODO send  email to unlock account

        return "User Account Created";
    }

    @Override
    public String unlockAccount(UnlockAccount unlockAccount) {
        String email= unlockAccount.getEmail();

        UserDetails userDetails = userRepo.findByEmail(email);

        if (userDetails != null && userDetails.getAccountPassword().equals(unlockAccount.getTemPassword())) {
            userDetails.setAccountPassword(unlockAccount.getNewPassword());
            userDetails.setAccountStatus("Unlocked");
            userRepo.save(userDetails);
            return "Account Unlocked";
        }
        return "Invalid Password";

    }

    @Override
    public String login(LoginForm loginForm) {
        UserDetails userDetails = userRepo.findEmailAndPwd(loginForm.getEmail(), loginForm.getPassword());
        if (userDetails == null) {
            return "Invalid Credentials";
        }
        if (userDetails.getAccountStatus().equals("Locked")) {
            return "Account Locked";

        }
        return "Success";
    }

    @Override
    public String forgotPwd(String email) {
        UserDetails userDetails = userRepo.findByEmail(email);
        if (userDetails == null) {
            return "No account Found";
        }

        // Todo send email to user with pwd
        return null;
    }


}
