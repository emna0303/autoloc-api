package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.web.dto.ContratRequest;
import tn.esprit.autolocapi.web.dto.ContratResponse;

@Component
public class ContratMapper {

    // The reservation relation is set by the service.
    public Contrat toEntity(ContratRequest request) {
        Contrat contrat = new Contrat();
        updateEntity(contrat, request);
        return contrat;
    }

    public void updateEntity(Contrat contrat, ContratRequest request) {
        contrat.setDateSignature(request.dateSignature());
        contrat.setMontantTotal(request.montantTotal());
        contrat.setValide(request.valide());
    }

    public ContratResponse toResponse(Contrat contrat) {
        return new ContratResponse(
                contrat.getIdContrat(),
                contrat.getDateSignature(),
                contrat.getMontantTotal(),
                contrat.isValide(),
                contrat.getReservation().getIdReservation());
    }
}
