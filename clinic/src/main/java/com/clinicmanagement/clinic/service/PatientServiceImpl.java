package com.clinicmanagement.clinic.service;

import com.clinicmanagement.clinic.entity.Patient;
import com.clinicmanagement.clinic.exception.ResourceNotFoundException;
import com.clinicmanagement.clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatienceService{


    @Autowired
    private PatientRepository patientRepository;

    @Override
    public boolean isPhoneNumberUnique(String phone_no) {
        return patientRepository.getUserByPhone_no(phone_no)==null;
    }

    @Override
    public Patient savePatient(Patient patient) {
        Patient newPatient=patientRepository.save(patient);
        if (newPatient!=null){
            return newPatient;
        }
        else
            throw new ResourceNotFoundException(
                    "Patient not found");


//        return newPatient;


//    try {
//
//       Patient newPatient=patientRepository.save(patient);
//        return newPatient;
//
//    }
//    catch (Exception e){
//        throw  new ResourceNotFoundException(
//                "patient not found");
//
//
//    }


    }

    @Override
    public void deletePatient(int pid) {
    patientRepository.deleteById(pid);
    }

    @Override
    public Patient updatePatient(int pid, Patient patient) {
        Patient patientToUpdate=patientRepository.findById(pid).orElseThrow();
        patientToUpdate.setPid(patient.getPid());
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setAppointment_date(patient.getAppointment_date());
        patientToUpdate.setDischarge_date(patient.getDischarge_date());
        patientToUpdate.setGender(patient.getGender());
        patientToUpdate.setPhone_no(patient.getPhone_no());
        patientToUpdate.setAddress(patient.getAddress());

        return patientRepository.save(patientToUpdate);
    }

    @Override
    public Patient getSinglePatient(int pid) {
        Optional<Patient> patient =patientRepository.findById(pid);
        if (patient.isPresent()){
            return patient.get();
        }
        throw new RuntimeException("Patient is not found for the id"+pid);
    }

//    @Override
//    public Patient getUserByName(String name) {
//        return patientRepository.getUserByName(name);
//    }

    @Override
    public List<Patient> getAllUsers() {
        return patientRepository.getAllUsers();
    }

    @Override
    public List<Patient> searchPatients(String query) {
        List<Patient> patients=patientRepository.searchPatients(query);
        return patients;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }


}



