package dev.dulipsameera.patientservice.service.impl;

import dev.dulipsameera.patientservice.dto.PatientRequestDTO;
import dev.dulipsameera.patientservice.dto.PatientResponseDTO;
import dev.dulipsameera.patientservice.exception.custom.EmailAlreadyExistsException;
import dev.dulipsameera.patientservice.exception.custom.PatientNotFoundException;
import dev.dulipsameera.patientservice.grpc.BillingServiceGrpcClient;
import dev.dulipsameera.patientservice.kafka.KafkaProducer;
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
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    public PatientServiceImpl(PatientRepository patientRepository, BillingServiceGrpcClient  billingServiceGrpcClient, KafkaProducer kafkaProducer) {
        this.patientRepository = patientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
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
        billingServiceGrpcClient.createBillingAccount(patient.getId().toString(),
                patient.getName(), patient.getEmail());
        kafkaProducer.sendEvent(patient);
        return PatientMapper.toPatientResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with ID : " + id));
        handleIfPatientExistsByEmail(patientRequestDTO.getEmail(), id);
        // update patient fields
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        return PatientMapper.toPatientResponseDTO(patientRepository.save(patient));
    }

    @Override
    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }

    private void handleIfPatientExistsByEmail(String email) {
        if (patientRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Patient from this email already exists " + email);
        }
    }

    private void handleIfPatientExistsByEmail(String email, UUID id) {
        if (patientRepository.existsByEmailAndIdNot(email, id)) {
            throw new EmailAlreadyExistsException("Patient from this email already exists " + email);
        }
    }
}
