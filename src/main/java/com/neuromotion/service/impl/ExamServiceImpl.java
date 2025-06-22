package com.neuromotion.service.impl;

import com.neuromotion.model.Exam;
import com.neuromotion.repo.IGenericRepo;
import com.neuromotion.repo.IExamRepo;
import com.neuromotion.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl extends CRUDImpl<Exam, Integer> implements IExamService {

    @Autowired
    private IExamRepo repo;

    @Override
    protected IGenericRepo<Exam, Integer> getRepo() {
        return repo;
    }
}
