package com.mitocode.service;

import com.mitocode.model.ConsultExam;
import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;

import java.util.List;

public interface IPatientSignService {
    Patient saveSignsTransactional(Patient patient, List<PatientVitalSign> signs);
    List<PatientVitalSign> getSignsByPatientId(Integer idPatient);

}
