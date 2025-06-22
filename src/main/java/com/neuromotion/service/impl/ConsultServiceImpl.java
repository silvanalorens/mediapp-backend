package com.neuromotion.service.impl;

import com.neuromotion.dto.ConsultProcDTO;
import com.neuromotion.model.Consult;
import com.neuromotion.model.Exam;
import com.neuromotion.repo.IConsultExamRepo;
import com.neuromotion.repo.IConsultRepo;
import com.neuromotion.repo.IGenericRepo;
import com.neuromotion.service.IConsultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultServiceImpl extends CRUDImpl<Consult, Integer> implements IConsultService {

    @Autowired
    private IConsultRepo consultRepo;

    @Autowired
    private IConsultExamRepo ceRepo;

    @Override
    protected IGenericRepo<Consult, Integer> getRepo() {
        return consultRepo;
    }

    @Transactional //(rollbackFor = ModelNotFoundException.class) //para rollback manual
    @Override
    public Consult saveTransactional(Consult consult, List<Exam> exams) {
        consultRepo.save(consult);
        exams.forEach(ex -> ceRepo.saveExam(consult.getIdConsult(), ex.getIdExam()));

        return consult;
    }

    @Override
    public List<Consult> search(String dni, String fullname) {
        return consultRepo.search(dni, fullname);
    }

    @Override
    public List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2) {
        return consultRepo.searchByDates(date1, date2.plusDays(1));
    }

    @Override
    public List<ConsultProcDTO> callProcedureOrFunction() {
        List<ConsultProcDTO> consults = new ArrayList<>();
            /*
    [4,	"12/11/2022]"
    [1,	"19/11/2022]"
    [2,	"20/11/2022]"
     */
        consultRepo.callProcedureOrFunction().forEach(x -> {
            ConsultProcDTO dto = new ConsultProcDTO();
            dto.setQuantity((Integer) x[0]);
            dto.setConsultdate((String) x[1]);
            consults.add(dto);
        });
        return consults;
    }

}
