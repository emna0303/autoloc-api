package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratRequest(
        @NotNull(message = "La date de signature est obligatoire")
        LocalDate dateSignature,

        @NotNull(message = "Le montant total est obligatoire")
        @DecimalMin(value = "0.00", message = "Le montant total ne doit pas être négatif")
        BigDecimal montantTotal,

        boolean valide,

        @NotNull(message = "reservationId est obligatoire")
        Long reservationId) {
}
