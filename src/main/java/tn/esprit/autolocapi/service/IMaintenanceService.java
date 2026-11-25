package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.MaintenanceRequest;
import tn.esprit.autolocapi.web.dto.MaintenanceResponse;

public interface IMaintenanceService {
    MaintenanceResponse create(MaintenanceRequest request);
    List<MaintenanceResponse> findAll();
    MaintenanceResponse findById(Long id);
    MaintenanceResponse update(Long id, MaintenanceRequest request);
    void delete(Long id);
}
