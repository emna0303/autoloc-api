package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.web.dto.EmployeRequest;
import tn.esprit.autolocapi.web.dto.EmployeResponse;

@Component
public class EmployeMapper {

    // The agence relation is set by the service, because it needs the repository.
    public Employe toEntity(EmployeRequest request) {
        Employe employe = new Employe();
        updateEntity(employe, request);
        return employe;
    }

    public void updateEntity(Employe employe, EmployeRequest request) {
        employe.setNom(request.nom());
        employe.setPrenom(request.prenom());
        employe.setRole(request.role());
    }

    public EmployeResponse toResponse(Employe employe) {
        return new EmployeResponse(
                employe.getIdEmploye(),
                employe.getNom(),
                employe.getPrenom(),
                employe.getRole(),
                employe.getAgence().getIdAgence());
    }
}
