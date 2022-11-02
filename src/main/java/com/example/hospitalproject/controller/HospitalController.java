package com.example.hospitalproject.controller;

import com.example.hospitalproject.dao.HospitalDao;
import com.example.hospitalproject.domain.Hospital;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hosapi")
public class HospitalController {
    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping(value = "/hospital/{id}")
    public ResponseEntity<Hospital> findById(int id){
        try{
            return ResponseEntity
                    .ok()
                    .body(hospitalDao.findById(id));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
