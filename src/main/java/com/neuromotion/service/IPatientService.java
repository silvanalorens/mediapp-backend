package com.neuromotion.service;

import com.neuromotion.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPatientService extends ICRUD<Patient, Integer> {

    Page<Patient> listPage(Pageable pageable);

}
