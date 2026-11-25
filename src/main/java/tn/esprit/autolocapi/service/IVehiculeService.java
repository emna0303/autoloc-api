package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.VehiculeRequest;
import tn.esprit.autolocapi.web.dto.VehiculeResponse;

public interface IVehiculeService {
    VehiculeResponse create(VehiculeRequest request);
    List<VehiculeResponse> findAll();
    VehiculeResponse findById(Long id);
    VehiculeResponse update(Long id, VehiculeRequest request);
    void delete(Long id);
}
