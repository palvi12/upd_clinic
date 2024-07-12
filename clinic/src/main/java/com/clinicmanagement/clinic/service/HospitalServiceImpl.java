package com.clinicmanagement.clinic.service;

import com.clinicmanagement.clinic.entity.Hospital;
import com.clinicmanagement.clinic.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService{
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(int hid) {
        hospitalRepository.deleteById(hid);
    }





    @Override
    public Hospital updateHospital(int hid, Hospital hospital) {
        Hospital hospitalToUpdate=hospitalRepository.findById(hid).orElseThrow();
        hospitalToUpdate.setHid(hospital.getHid());
        hospitalToUpdate.setHAddress(hospital.getHAddress());
        hospitalToUpdate.setHName(hospital.getHName());
        hospitalToUpdate.setHPhoneNumber(hospital.getHPhoneNumber());
        hospitalToUpdate.setHGmail(hospital.getHGmail());

        return hospitalRepository.save(hospitalToUpdate);


    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.getAllHospital();
    }

    @Override
    public Hospital getSingleHospital(int hid) {
        Optional<Hospital> hospital=hospitalRepository.findById(hid);
        if (hospital.isPresent()){
            return hospital.get();
        }
        throw new RuntimeException("Hospital is not found for the id"+hid);

    }
}
