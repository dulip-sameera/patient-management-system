package dev.dulipsameera.patientservice.util.mapper;

import dev.dulipsameera.patientservice.dto.PatientResponseDTO;
import dev.dulipsameera.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO mapToPatientResponseDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(String.valueOf(patient.getId()));
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientResponseDTO;
    }
}
