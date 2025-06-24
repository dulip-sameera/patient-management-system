package dev.dulipsameera.patientservice.service;

import dev.dulipsameera.patientservice.dto.PatientRequestDTO;
import dev.dulipsameera.patientservice.dto.PatientResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO);
    void deletePatient(UUID id);
}
