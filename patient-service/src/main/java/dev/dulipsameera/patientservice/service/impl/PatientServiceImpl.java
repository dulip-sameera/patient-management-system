package dev.dulipsameera.patientservice.service.impl;

import dev.dulipsameera.patientservice.repository.PatientRepository;
import dev.dulipsameera.patientservice.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


}
