package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.MaintenanceMapper;
import tn.esprit.autolocapi.repository.IMaintenanceRepository;
import tn.esprit.autolocapi.repository.IVehiculeRepository;
import tn.esprit.autolocapi.service.IMaintenanceService;
import tn.esprit.autolocapi.web.dto.MaintenanceRequest;
import tn.esprit.autolocapi.web.dto.MaintenanceResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final MaintenanceMapper maintenanceMapper;

    @Override
    public MaintenanceResponse create(MaintenanceRequest request) {
        Maintenance maintenance = maintenanceMapper.toEntity(request);
        maintenance.setVehicule(findVehicule(request.vehiculeId()));
        return maintenanceMapper.toResponse(maintenanceRepository.save(maintenance));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaintenanceResponse> findAll() {
        return maintenanceRepository.findAll().stream().map(maintenanceMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MaintenanceResponse findById(Long id) {
        return maintenanceMapper.toResponse(getOrThrow(id));
    }

    @Override
    public MaintenanceResponse update(Long id, MaintenanceRequest request) {
        Maintenance maintenance = getOrThrow(id);
        maintenanceMapper.updateEntity(maintenance, request);
        maintenance.setVehicule(findVehicule(request.vehiculeId()));
        return maintenanceMapper.toResponse(maintenanceRepository.save(maintenance));
    }

    @Override
    public void delete(Long id) {
        maintenanceRepository.delete(getOrThrow(id));
    }

    private Maintenance getOrThrow(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance", id));
    }

    private Vehicule findVehicule(Long vehiculeId) {
        return vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", vehiculeId));
    }
}
