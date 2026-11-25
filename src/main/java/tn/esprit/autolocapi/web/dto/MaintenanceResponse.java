package tn.esprit.autolocapi.web.dto;

import java.time.LocalDate;

public record MaintenanceResponse(
        Long idMaintenance,
        LocalDate dateDebut,
        LocalDate dateFin,
        String description,
        Long vehiculeId) {
}

