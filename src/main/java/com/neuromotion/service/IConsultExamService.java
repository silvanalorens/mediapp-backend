package com.neuromotion.service;

import com.neuromotion.model.ConsultExam;

import java.util.List;

public interface IConsultExamService {

    List<ConsultExam> getExamsByConsultId(Integer idConsult);

}
