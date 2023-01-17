package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientSignsDTO {


    @EqualsAndHashCode.Include
    private Integer idVitalSign;

    @NotNull
    private LocalDateTime signDate;

    @NotNull
    private String temperature;

    @NotNull
    private String pulse;


    @NotNull
    private String respiratory;

    private Integer patientIdPatient;

    private String patientFirstName;

    private String patientLastName;


}
