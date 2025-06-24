package dev.dulipsameera.patientservice.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PatientResponseDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
}
