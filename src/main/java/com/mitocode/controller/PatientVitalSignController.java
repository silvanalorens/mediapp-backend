package com.mitocode.controller;


import com.mitocode.dto.PatientVitalSignDTO;
import com.mitocode.exception.ModelNotFoundException;

import com.mitocode.model.PatientVitalSign;

import com.mitocode.service.IPatientSignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/signs")
//@CrossOrigin(origins = "*")
public class PatientVitalSignController {


    @Autowired
    private IPatientSignService serviceSigns;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PatientVitalSignDTO>> findAll(){

        List<PatientVitalSignDTO> list = serviceSigns.findAll().stream().map(p -> mapper.map(p, PatientVitalSignDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientVitalSignDTO> findById(@PathVariable("id") Integer id){
        PatientVitalSign obj = serviceSigns.findById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return new ResponseEntity<>(mapper.map(obj, PatientVitalSignDTO.class), HttpStatus.OK);
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
        PatientVitalSign obj = serviceSigns.findById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        serviceSigns.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }






}
