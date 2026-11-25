package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.web.dto.AgenceRequest;
import tn.esprit.autolocapi.web.dto.AgenceResponse;

@Component
public class AgenceMapper {

    public Agence toEntity(AgenceRequest request) {
        Agence agence = new Agence();
        updateEntity(agence, request);
        return agence;
    }

    public void updateEntity(Agence agence, AgenceRequest request) {
        agence.setNom(request.nom());
        agence.setVille(request.ville());
        agence.setAdresse(request.adresse());
        agence.setTelephone(request.telephone());
    }

    public AgenceResponse toResponse(Agence agence) {
        return new AgenceResponse(
                agence.getIdAgence(),
                agence.getNom(),
                agence.getVille(),
                agence.getAdresse(),
                agence.getTelephone());
    }
}
