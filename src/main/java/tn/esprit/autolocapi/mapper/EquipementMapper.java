package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.web.dto.EquipementRequest;
import tn.esprit.autolocapi.web.dto.EquipementResponse;

@Component
public class EquipementMapper {

    public Equipement toEntity(EquipementRequest request) {
        Equipement equipement = new Equipement();
        updateEntity(equipement, request);
        return equipement;
    }

    public void updateEntity(Equipement equipement, EquipementRequest request) {
        equipement.setLibelle(request.libelle());
    }

    public EquipementResponse toResponse(Equipement equipement) {
        return new EquipementResponse(equipement.getIdEquipement(), equipement.getLibelle());
    }
}
