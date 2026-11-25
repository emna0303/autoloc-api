package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Paiement;
import tn.esprit.autolocapi.web.dto.PaiementResponse;

@Component
public class PaiementMapper {

    public PaiementResponse toResponse(Paiement paiement) {
        return new PaiementResponse(
                paiement.getIdPaiement(),
                paiement.getMontant(),
                paiement.getDatePaiement(),
                paiement.getModePaiement(),
                paiement.getContrat().getIdContrat());
    }
}
