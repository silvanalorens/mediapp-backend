package com.mitocode.service;

import com.mitocode.model.Consult;
import com.mitocode.model.Exam;
import com.mitocode.model.Patient;
import com.mitocode.model.VitalSign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService extends ICRUD<Patient, Integer> {

    Page<Patient> listPage(Pageable pageable);
    Patient saveTransactional(Patient patient, List<VitalSign> signs);
}
