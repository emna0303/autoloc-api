package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tn.esprit.autolocapi.domain.RoleEmploye;

public record EmployeRequest(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire")
        @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
        String prenom,

        @NotNull(message = "Le rôle est obligatoire (AGENT ou MANAGER)")
        RoleEmploye role,

        @NotNull(message = "agenceId est obligatoire")
        Long agenceId) {
}
