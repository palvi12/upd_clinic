package com.clinicmanagement.clinic.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;



@AllArgsConstructor

@NoArgsConstructor
@ToString
@Entity

public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   @NotBlank(message = "hid is mandatory")
    @Column(name = "hid")
    private int hid;

    @NotBlank(message = "HName is mandatory")
    @Column(name = "HName")
    private String HName;

    @NotBlank(message = "HAddress is mandatory")
    @Column(name = "HAddress")
    private String HAddress;

    @Email(message = "Please provide a valid email address")
    @Column(name = "HGmail")
    private String HGmail;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHName() {
        return HName;
    }

    public void setHName(String HName) {
        this.HName = HName;
    }

    public String getHAddress() {
        return HAddress;
    }

    public void setHAddress(String HAddress) {
        this.HAddress = HAddress;
    }

    public String getHGmail() {
        return HGmail;
    }

    public void setHGmail(String HGmail) {
        this.HGmail = HGmail;
    }

    public String getHPhoneNumber() {
        return HPhoneNumber;
    }

    public void setHPhoneNumber(String HPhoneNumber) {
        this.HPhoneNumber = HPhoneNumber;
    }

    @Size(min=10,max=10)
    @NotBlank(message = "HPhoneNumber is mandatory")
    @Column(name = "HPhoneNumber")
    private String HPhoneNumber;



    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @OneToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "hid")
    private List<Patient> patients;




}
