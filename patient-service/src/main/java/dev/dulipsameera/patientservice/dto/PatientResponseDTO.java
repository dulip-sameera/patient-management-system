package dev.dulipsameera.patientservice.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class PatientResponseDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String dateOfBirth;
}
