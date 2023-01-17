package com.mitocode.service.impl;

import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.repo.IPatientSignRepo;
import com.mitocode.service.IPatientSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<PatientVitalSign> getSignsByPatientId(Integer idPatient) {
        return repo.getSignsByPatientId(idPatient);
    }

    @Override
    public Page<PatientVitalSign> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
    @Override
    public List<PatientVitalSign> findAll() {

        return repo.findAll();
    }
}

