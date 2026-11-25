package tn.esprit.autolocapi.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import tn.esprit.autolocapi.domain.StatutReservation;

public record ReservationRequest(
        @NotNull(message = "La date de début est obligatoire")
        LocalDate dateDebut,

        @NotNull(message = "La date de fin est obligatoire")
        LocalDate dateFin,

        @NotNull(message = "Le statut est obligatoire (EN_ATTENTE, CONFIRMEE, ANNULEE, TERMINEE)")
        StatutReservation statut,

        @NotNull(message = "vehiculeId est obligatoire")
        Long vehiculeId,

        @NotNull(message = "clientId est obligatoire")
        Long clientId) {

    @JsonIgnore
    @AssertTrue(message = "La date de fin ne doit pas être antérieure à la date de début")
    public boolean isPeriodeValide() {
        return dateDebut == null || dateFin == null || !dateFin.isBefore(dateDebut);
    }
}
