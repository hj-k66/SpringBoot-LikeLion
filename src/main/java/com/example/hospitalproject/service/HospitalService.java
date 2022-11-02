package com.example.hospitalproject.service;

import com.example.hospitalproject.dao.HospitalDao;
import com.example.hospitalproject.domain.Hospital;
import com.example.hospitalproject.parser.ReadLineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class HospitalService {
    private final ReadLineContext<Hospital> hospitalReadLineContext;
    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    @Transactional
    public int insertHospitalData(String filename) {
        int cnt = 0;
        try {
            List<Hospital> hospitals = this.hospitalReadLineContext.readByLine(filename);

            for (Hospital hospital : hospitals) {
                try {
                    this.hospitalDao.add(hospital);
                    cnt++;
                } catch (Exception e) {
                    System.out.printf("id: %d에 문제가 있습니다.\n", hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

}
