package com.Abdul.MiniProject.Repo;

import com.Abdul.MiniProject.Entity.StateMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface StateRepo extends JpaRepository<StateMaster, Serializable> {

    public List<StateMaster> findByCountryId(Integer countryId);
}
