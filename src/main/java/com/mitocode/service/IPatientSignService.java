package com.mitocode.service;

import com.mitocode.model.ConsultExam;
import com.mitocode.model.Exam;
import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientSignService  extends ICRUD<PatientVitalSign, Integer>  {
    List<PatientVitalSign> getSignsByPatientId(Integer idPatient);
    Page<PatientVitalSign> listPage(Pageable pageable);

    public PatientVitalSign save(PatientVitalSign t);
}
