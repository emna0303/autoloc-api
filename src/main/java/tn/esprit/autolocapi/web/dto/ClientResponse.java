package tn.esprit.autolocapi.web.dto;

import java.time.LocalDate;

public record ClientResponse(
        Long idClient,
        String nom,
        String prenom,
        String email,
        String telephone,
        String numPermis,
        LocalDate dateInscription) {
}
