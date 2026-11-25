package tn.esprit.autolocapi.web.dto;

import java.math.BigDecimal;
import java.util.Set;
import tn.esprit.autolocapi.domain.CategorieVehicule;
import tn.esprit.autolocapi.domain.StatutVehicule;

public record VehiculeResponse(
        Long idVehicule,
        String immatriculation,
        String marque,
        String modele,
        CategorieVehicule categorie,
        BigDecimal tarifJournalier,
        StatutVehicule statut,
        Long agenceId,
        Set<Long> equipementIds) {
}
