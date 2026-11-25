package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;
import tn.esprit.autolocapi.domain.CategorieVehicule;
import tn.esprit.autolocapi.domain.StatutVehicule;

public record VehiculeRequest(
        @NotBlank(message = "L'immatriculation est obligatoire")
        @Size(max = 20, message = "L'immatriculation ne doit pas dépasser 20 caractères")
        String immatriculation,

        @NotBlank(message = "La marque est obligatoire")
        @Size(max = 50, message = "La marque ne doit pas dépasser 50 caractères")
        String marque,

        @NotBlank(message = "Le modèle est obligatoire")
        @Size(max = 50, message = "Le modèle ne doit pas dépasser 50 caractères")
        String modele,

        @NotNull(message = "La catégorie est obligatoire (BERLINE, CITADINE, SUV, UTILITAIRE)")
        CategorieVehicule categorie,

        @NotNull(message = "Le tarif journalier est obligatoire")
        @DecimalMin(value = "0.01", message = "Le tarif journalier doit être supérieur à 0")
        BigDecimal tarifJournalier,

        @NotNull(message = "Le statut est obligatoire (DISPONIBLE, LOUE, MAINTENANCE)")
        StatutVehicule statut,

        @NotNull(message = "agenceId est obligatoire")
        Long agenceId,

        Set<Long> equipementIds) {
}
