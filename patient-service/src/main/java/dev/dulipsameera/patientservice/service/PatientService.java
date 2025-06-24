package dev.dulipsameera.patientservice.service;

import dev.dulipsameera.patientservice.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();
}
