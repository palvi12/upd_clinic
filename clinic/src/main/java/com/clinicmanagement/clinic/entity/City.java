package com.clinicmanagement.clinic.entity;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   @NotBlank(message = "id is mandatory")
    @Column(name = "id")
    private int id;


   @NotBlank(message = "city_name is mandatory")
    @Column(name = "city_name")
    private String city_name;
    
    @NotBlank(message = "state_code is mandatory")
    @Column(name = "state_code")
    private int state_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getState_code() {
        return state_code;
    }

    public void setState_code(int state_code) {
        this.state_code = state_code;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @OneToMany(targetEntity = Hospital.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "rp_pr",referencedColumnName ="id")
    private List<Hospital> hospitals;





}
