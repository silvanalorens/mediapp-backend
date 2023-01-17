package com.mitocode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PatientVitalSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idVitalSign;

    @Column(nullable = false) //yyyy-mm-ddTHH:mm:ss
    private LocalDateTime signDate;

    @Column(nullable = false)
    private String temperature;

    @Column(nullable = false)
    private String pulse;

    @Column(nullable = false)
    private String respiratory;

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_PATIENT_SIGN"))
    private Patient patient;
}
