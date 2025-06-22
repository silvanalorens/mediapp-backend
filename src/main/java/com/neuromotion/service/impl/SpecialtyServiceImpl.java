package com.neuromotion.service.impl;

import com.neuromotion.model.Specialty;
import com.neuromotion.repo.ISpecialtyRepo;
import com.neuromotion.repo.IGenericRepo;
import com.neuromotion.service.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl extends CRUDImpl<Specialty, Integer> implements ISpecialtyService {

    @Autowired
    private ISpecialtyRepo repo;

    @Override
    protected IGenericRepo<Specialty, Integer> getRepo() {
        return repo;
    }
}
