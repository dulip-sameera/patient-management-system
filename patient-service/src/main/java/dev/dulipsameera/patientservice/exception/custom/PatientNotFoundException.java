package dev.dulipsameera.patientservice.exception.custom;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
