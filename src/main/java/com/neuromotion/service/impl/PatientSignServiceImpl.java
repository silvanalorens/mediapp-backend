package com.neuromotion.service.impl;

import com.neuromotion.model.PatientVitalSign;
import com.neuromotion.repo.IGenericRepo;
import com.neuromotion.repo.IPatientSignRepo;
import com.neuromotion.service.IPatientSignService;
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
    @Override
    public PatientVitalSign save(PatientVitalSign t) {
        return repo.save(t);
    }
}

