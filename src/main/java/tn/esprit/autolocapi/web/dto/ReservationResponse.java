package tn.esprit.autolocapi.web.dto;

import java.time.LocalDate;
import tn.esprit.autolocapi.domain.StatutReservation;

public record ReservationResponse(
        Long idReservation,
        LocalDate dateDebut,
        LocalDate dateFin,
        StatutReservation statut,
        Long vehiculeId,
        Long clientId) {
}
