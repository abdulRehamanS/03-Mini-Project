package com.Abdul.MiniProject.Service;

import com.Abdul.MiniProject.Binding.LoginForm;
import com.Abdul.MiniProject.Binding.UnlockAccount;
import com.Abdul.MiniProject.Binding.UserForm;

import java.util.Map;

public interface InterfaceServcie {


    public String checkEmail (String email);

    public Map<Integer, String> getCountries ( ) ;

    public Map<Integer, String> getStates (Integer countryId);

    public Map<Integer, String> getCities (Integer stateId);

    public String registerUser (UserForm userForm);

    public String unlockAccount (UnlockAccount unlockAccount);

    public String login (LoginForm loginForm);

    public String forgotPwd (String email);
}
