package com.mitocode.repo;

import com.mitocode.model.ConsultExam;
import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPatientSignRepo extends IGenericRepo<PatientVitalSign, Integer>{
    @Modifying
    @Query(value = "INSERT INTO patient_sign(id_patient, id_vital_sign) VALUES(:idPatient, :idVitalSign)", nativeQuery = true)
    void saveSign(Integer idPatient, Integer idVitalSign);

    @Query("FROM PatientVitalSign ps WHERE ps.patient.idPatient = :idPatient")
    List<PatientVitalSign> getSignsByPatientId(@Param("idPatient") Integer idPatient);
}
