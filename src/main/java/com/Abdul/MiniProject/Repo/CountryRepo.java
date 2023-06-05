package com.Abdul.MiniProject.Repo;

import com.Abdul.MiniProject.Entity.CountryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CountryRepo extends JpaRepository<CountryMaster, Serializable> {
}
