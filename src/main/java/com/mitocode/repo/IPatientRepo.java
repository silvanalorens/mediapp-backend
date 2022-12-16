package com.mitocode.repo;

import com.mitocode.model.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface IPatientRepo extends IGenericRepo<Patient, Integer> {

    @Modifying
    @Query(value = "INSERT INTO patient_sign(id_patient, id_vital_sign) VALUES(:idPatient, :idVitalSign)", nativeQuery = true)
    void saveSign(Integer idPatient, Integer idVitalSign);
}
