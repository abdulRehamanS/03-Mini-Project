package com.Abdul.MiniProject.Repo;

import com.Abdul.MiniProject.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserRepo extends JpaRepository<UserDetails, Serializable> {



    //select * from userDetails where email=?
    public UserDetails findByEmail(String email);

    public UserDetails findEmailAndPwd(String email , String pws);


}
