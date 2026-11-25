package tn.esprit.autolocapi.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.VehiculeMapper;
import tn.esprit.autolocapi.repository.IAgenceRepository;
import tn.esprit.autolocapi.repository.IEquipementRepository;
import tn.esprit.autolocapi.repository.IVehiculeRepository;
import tn.esprit.autolocapi.service.IVehiculeService;
import tn.esprit.autolocapi.web.dto.VehiculeRequest;
import tn.esprit.autolocapi.web.dto.VehiculeResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final IEquipementRepository equipementRepository;
    private final VehiculeMapper vehiculeMapper;

    @Override
    public VehiculeResponse create(VehiculeRequest request) {
        Vehicule vehicule = vehiculeMapper.toEntity(request);
        remplirRelations(vehicule, request);
        return vehiculeMapper.toResponse(vehiculeRepository.save(vehicule));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeResponse> findAll() {
        return vehiculeRepository.findAll().stream().map(vehiculeMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public VehiculeResponse findById(Long id) {
        return vehiculeMapper.toResponse(getOrThrow(id));
    }

    @Override
    public VehiculeResponse update(Long id, VehiculeRequest request) {
        Vehicule vehicule = getOrThrow(id);
        vehiculeMapper.updateEntity(vehicule, request);
        remplirRelations(vehicule, request);
        return vehiculeMapper.toResponse(vehiculeRepository.save(vehicule));
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.delete(getOrThrow(id));
    }

    private Vehicule getOrThrow(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }

    // Loads the agence and the equipements from their ids and links them to the vehicule.
    private void remplirRelations(Vehicule vehicule, VehiculeRequest request) {
        Agence agence = agenceRepository.findById(request.agenceId())
                .orElseThrow(() -> new ResourceNotFoundException("Agence", request.agenceId()));
        vehicule.setAgence(agence);

        Set<Equipement> equipements = new HashSet<>();
        if (request.equipementIds() != null) {
            for (Long equipementId : request.equipementIds()) {
                equipements.add(equipementRepository.findById(equipementId)
                        .orElseThrow(() -> new ResourceNotFoundException("Equipement", equipementId)));
            }
        }
        vehicule.setEquipements(equipements);
    }
}
