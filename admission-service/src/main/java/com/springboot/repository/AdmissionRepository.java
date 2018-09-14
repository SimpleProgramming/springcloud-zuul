package com.springboot.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Admission;

@Repository
public interface AdmissionRepository extends CrudRepository<Admission, Serializable>{

}
