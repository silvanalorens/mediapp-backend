package com.neuromotion.service;

import com.neuromotion.model.PatientVitalSign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientSignService  extends ICRUD<PatientVitalSign, Integer>  {
    List<PatientVitalSign> getSignsByPatientId(Integer idPatient);
    Page<PatientVitalSign> listPage(Pageable pageable);

    public PatientVitalSign save(PatientVitalSign t);
}
