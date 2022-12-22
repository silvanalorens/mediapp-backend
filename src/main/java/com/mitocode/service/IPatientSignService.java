package com.mitocode.service;

import com.mitocode.model.ConsultExam;
import com.mitocode.model.Exam;
import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;

import java.util.List;

public interface IPatientSignService  extends ICRUD<PatientVitalSign, Integer>  {
    Patient saveSignsTransactional(Patient patient); //, List<PatientVitalSign> signs
    List<PatientVitalSign> getSignsByPatientId(Integer idPatient);

}
