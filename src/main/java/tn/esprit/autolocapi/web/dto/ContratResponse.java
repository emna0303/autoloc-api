
package tn.esprit.autolocapi.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratResponse(
        Long idContrat,
        LocalDate dateSignature,
        BigDecimal montantTotal,
        boolean valide,
        Long reservationId) {
}
