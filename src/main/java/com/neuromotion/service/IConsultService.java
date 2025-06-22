package com.neuromotion.service;

import com.neuromotion.dto.ConsultProcDTO;
import com.neuromotion.model.Consult;
import com.neuromotion.model.Exam;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultService extends ICRUD<Consult, Integer>{

    Consult saveTransactional(Consult consult, List<Exam> exams);
    List<Consult> search(String dni, String fullname);
    List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2);

    List<ConsultProcDTO> callProcedureOrFunction();


}
