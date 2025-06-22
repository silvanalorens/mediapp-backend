package com.neuromotion.service.impl;

import com.neuromotion.model.Medic;
import com.neuromotion.repo.IGenericRepo;
import com.neuromotion.repo.IMedicRepo;
import com.neuromotion.service.IMedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements IMedicService {

    @Autowired
    private IMedicRepo repo;

    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }
}
