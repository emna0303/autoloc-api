package tn.esprit.autolocapi.web.dto;

import tn.esprit.autolocapi.domain.RoleEmploye;

public record EmployeResponse(
        Long idEmploye,
        String nom,
        String prenom,
        RoleEmploye role,
        Long agenceId) {
}
