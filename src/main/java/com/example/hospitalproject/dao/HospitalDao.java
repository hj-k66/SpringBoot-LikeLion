package com.example.hospitalproject.dao;

import com.example.hospitalproject.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from national_hospitals");
    }

    public int getCount(){
        String sql = "SELECT count(id) from national_hospitals";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }


    public void add(Hospital hospital){
        String sql = "INSERT INTO `national_hospitals` (`id`, `open_service_name`, `open_local_government_code`," +
                " `management_number`, `license_date`, `business_status`," +
                " `business_status_code`, `phone`, `full_address`," +
                " `road_name_address`, `hospital_name`, `business_type_name`," +
                " `healthcare_provider_count`, `patient_room_count`, `total_number_of_beds`," +
                " `total_area_size`)" +
                " VALUES (?,?,?," +
                " ?,?,?," +
                " ?,?,?," +
                " ?,?,?," +
                " ?,?,?," +
                " ?);"; // 16개
        this.jdbcTemplate.update(sql,
                hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(), hospital.getFullAddress(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(),
                hospital.getTotalAreaSize()
        );
    }


}




