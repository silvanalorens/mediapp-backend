package com.mitocode.service.impl;

import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.repo.IPatientSignRepo;
import com.mitocode.service.IPatientSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientSignServiceImpl extends CRUDImpl<PatientVitalSign, Integer> implements IPatientSignService {

    @Autowired
    private IPatientSignRepo repo;

    @Override
    protected IGenericRepo<PatientVitalSign, Integer> getRepo() {
        return repo;
    }

    @Override
    public Patient saveSignsTransactional(Patient patient) {
        //List<PatientVitalSign> signs = patient.getSigns();
        //signs.forEach(ex -> repo.saveSign(patient.getIdPatient(), ex.getIdVitalSign()));

        //signs.forEach(vs -> repo.saveSign(patient.getIdPatient(), vs.getIdVitalSign()));
        return patient;
    }

    @Override
    public List<PatientVitalSign> getSignsByPatientId(Integer idPatient) {
        return repo.getSignsByPatientId(idPatient);
    }


}

