package com.Abdul.MiniProject.Repo;

import com.Abdul.MiniProject.Entity.CityMaster;
import com.Abdul.MiniProject.Entity.CountryMaster;
import com.Abdul.MiniProject.Entity.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface CityRepo extends JpaRepository<CityMaster, Serializable> {

    public List<CityMaster >findByStateId(Integer StateId);


}




