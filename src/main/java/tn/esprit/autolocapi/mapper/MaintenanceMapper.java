package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.web.dto.MaintenanceRequest;
import tn.esprit.autolocapi.web.dto.MaintenanceResponse;

@Component
public class MaintenanceMapper {

    // The vehicule relation is set by the service.
    public Maintenance toEntity(MaintenanceRequest request) {
        Maintenance maintenance = new Maintenance();
        updateEntity(maintenance, request);
        return maintenance;
    }

    public void updateEntity(Maintenance maintenance, MaintenanceRequest request) {
        maintenance.setDateDebut(request.dateDebut());
        maintenance.setDateFin(request.dateFin());
        maintenance.setDescription(request.description());
    }

    public MaintenanceResponse toResponse(Maintenance maintenance) {
        return new MaintenanceResponse(
                maintenance.getIdMaintenance(),
                maintenance.getDateDebut(),
                maintenance.getDateFin(),
                maintenance.getDescription(),
                maintenance.getVehicule().getIdVehicule());
    }
}
