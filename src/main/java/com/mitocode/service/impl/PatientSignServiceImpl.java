package com.mitocode.service.impl;

import com.mitocode.model.ConsultExam;
import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.repo.IPatientSignRepo;
import com.mitocode.service.IPatientSignService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientSignServiceImpl implements IPatientSignService {
    @Autowired
    private IPatientRepo repoPatient;
    @Autowired
    private IPatientSignRepo repo;


    @Override
    public Patient saveSignsTransactional(Patient patient, List<PatientVitalSign> signs) {
        repoPatient.save(patient);
        signs.forEach(vs -> repo.saveSign(patient.getIdPatient(), vs.getIdVitalSign()));
        return patient;
    }

    @Override
    public List<PatientVitalSign> getSignsByPatientId(Integer idPatient) {
        return repo.getSignsByPatientId(idPatient);
    }
}
