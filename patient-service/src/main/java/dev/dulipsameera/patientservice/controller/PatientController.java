package dev.dulipsameera.patientservice.controller;

import dev.dulipsameera.patientservice.dto.PatientResponseDTO;
import dev.dulipsameera.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO> patientResponseDTOs = patientService.getAllPatients();
        return ResponseEntity.ok().body(patientResponseDTOs);
    }
}
