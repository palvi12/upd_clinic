package com.clinicmanagement.clinic.controller;


import com.clinicmanagement.clinic.entity.Hospital;
import com.clinicmanagement.clinic.repository.HospitalRepository;
import com.clinicmanagement.clinic.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/addHospital")
    public String add(@RequestBody Hospital hospital){
        hospitalService.saveHospital(hospital);
        return "New hospital is added";
    }

    @DeleteMapping("/deleteHospital/{hid}")
    public String deleteHospital(@PathVariable int hid){
        hospitalService.deleteHospital(hid);
        return "hospital id is deleted";
    }
    @PutMapping("/updateHospital/{hid}")
    public Hospital updateHospital(@PathVariable int hid,@RequestBody Hospital hospital){
        return hospitalService.updateHospital(hid,hospital);
    }

    @GetMapping("/getAllHospital")
    public List<Hospital> getAllHospital(){
        return hospitalService.getAllHospital();
    }
    @GetMapping("/hospital/{hid}")
    public Hospital getHospital(@PathVariable int hid){
        return hospitalService.getSingleHospital(hid);
    }
}
