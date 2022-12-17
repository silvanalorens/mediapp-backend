package com.mitocode.repo;

import com.mitocode.model.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface IPatientRepo extends IGenericRepo<Patient, Integer> {


}
