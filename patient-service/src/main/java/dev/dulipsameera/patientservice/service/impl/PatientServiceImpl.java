package dev.dulipsameera.patientservice.service.impl;

import dev.dulipsameera.patientservice.dto.PatientRequestDTO;
import dev.dulipsameera.patientservice.dto.PatientResponseDTO;
import dev.dulipsameera.patientservice.exception.custom.EmailAlreadyExistsException;
import dev.dulipsameera.patientservice.exception.custom.PatientNotFoundException;
import dev.dulipsameera.patientservice.model.Patient;
import dev.dulipsameera.patientservice.repository.PatientRepository;
import dev.dulipsameera.patientservice.service.PatientService;
import dev.dulipsameera.patientservice.util.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toPatientResponseDTO).toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        handleIfPatientExistsByEmail(patientRequestDTO.getEmail());
        Patient patient = patientRepository.save(PatientMapper.toPatient(patientRequestDTO));
        return PatientMapper.toPatientResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with ID : " + id));
        handleIfPatientExistsByEmail(patientRequestDTO.getEmail());
        // update patient fields
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        return PatientMapper.toPatientResponseDTO(patientRepository.save(patient));
    }

    private void handleIfPatientExistsByEmail(String email) {
        if (patientRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Patient from this email already exists " + email);
        }
    }
}
