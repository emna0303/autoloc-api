package tn.esprit.autolocapi.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import tn.esprit.autolocapi.domain.ModePaiement;

public record PaiementResponse(
        Long idPaiement,
        BigDecimal montant,
        LocalDate datePaiement,
        ModePaiement modePaiement,
        Long contratId) {
}
