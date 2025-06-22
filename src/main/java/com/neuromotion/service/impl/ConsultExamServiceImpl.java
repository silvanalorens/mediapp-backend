package com.neuromotion.service.impl;

import com.neuromotion.model.ConsultExam;
import com.neuromotion.repo.IConsultExamRepo;
import com.neuromotion.service.IConsultExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultExamServiceImpl implements IConsultExamService {

    @Autowired
    private IConsultExamRepo repo;

    @Override
    public List<ConsultExam> getExamsByConsultId(Integer idConsult) {
        return repo.getExamsByConsultId(idConsult);
    }
}
