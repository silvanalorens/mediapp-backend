package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mitocode.model.Patient;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientVitalSignDTO {


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


    @JsonBackReference

    private PatientDTO patient;
}
