package tn.esprit.autolocapi.mapper;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.web.dto.VehiculeRequest;
import tn.esprit.autolocapi.web.dto.VehiculeResponse;

@Component
public class VehiculeMapper {

    // The agence and equipements relations are set by the service.
    public Vehicule toEntity(VehiculeRequest request) {
        Vehicule vehicule = new Vehicule();
        updateEntity(vehicule, request);
        return vehicule;
    }

    public void updateEntity(Vehicule vehicule, VehiculeRequest request) {
        vehicule.setImmatriculation(request.immatriculation());
        vehicule.setMarque(request.marque());
        vehicule.setModele(request.modele());
        vehicule.setCategorie(request.categorie());
        vehicule.setTarifJournalier(request.tarifJournalier());
        vehicule.setStatut(request.statut());
    }

    public VehiculeResponse toResponse(Vehicule vehicule) {
        Set<Long> equipementIds = vehicule.getEquipements().stream()
                .map(Equipement::getIdEquipement)
                .collect(Collectors.toSet());
        return new VehiculeResponse(
                vehicule.getIdVehicule(),
                vehicule.getImmatriculation(),
                vehicule.getMarque(),
                vehicule.getModele(),
                vehicule.getCategorie(),
                vehicule.getTarifJournalier(),
                vehicule.getStatut(),
                vehicule.getAgence().getIdAgence(),
                equipementIds);
    }
}
