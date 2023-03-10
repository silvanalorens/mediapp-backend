package com.mitocode.controller;



import com.mitocode.dto.PatientDTO;
import com.mitocode.dto.PatientSignsDTO;
import com.mitocode.dto.PatientVitalSignDTO;
import com.mitocode.exception.ModelNotFoundException;

import com.mitocode.model.Patient;
import com.mitocode.model.PatientVitalSign;

import com.mitocode.service.IPatientService;
import com.mitocode.service.IPatientSignService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/signs")
//@CrossOrigin(origins = "*")
public class PatientVitalSignController {


    @Autowired
    private IPatientSignService serviceSigns;

    @Autowired
    private IPatientService servicePatients;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PatientSignsDTO>> findAll(){

                //con mapper

        List<PatientSignsDTO> list = serviceSigns.findAll().stream().map(
                p -> mapper.map(p, PatientSignsDTO.class)
        ).collect(Collectors.toList());


        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientSignsDTO> findById(@PathVariable("id") Integer id){


        PatientVitalSign obj = serviceSigns.findById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }

        return new ResponseEntity<>(mapper.map(obj, PatientSignsDTO.class), HttpStatus.OK);




    }

    @GetMapping("/parent/{id}")
    public ResponseEntity<PatientDTO> findParentById(@PathVariable("id") Integer id){


        PatientVitalSign obj = serviceSigns.findById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        Patient patient = servicePatients.findById(obj.getPatient().getIdPatient());

        PatientDTO patientDTO = mapper.map(patient, PatientDTO.class);

        return new ResponseEntity<>(patientDTO, HttpStatus.OK);



    }


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PatientVitalSignDTO dto){
        PatientVitalSign obj = serviceSigns.save(mapper.map(dto, PatientVitalSign.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVitalSign()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PatientVitalSign> update(@Valid @RequestBody PatientVitalSignDTO dto){
        PatientVitalSign obj = serviceSigns.update(mapper.map(dto, PatientVitalSign.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        System.out.println("delete" + id);

        PatientVitalSign obj = serviceSigns.findById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        serviceSigns.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/pageable")
    public ResponseEntity<Page<PatientVitalSignDTO>> listPage(Pageable pageable){
        Page<PatientVitalSignDTO> page = serviceSigns.listPage(pageable).map(p->mapper.map(p, PatientVitalSignDTO.class));

        return new ResponseEntity<>(page, HttpStatus.OK);
    }



}
