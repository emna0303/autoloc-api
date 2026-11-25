package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.EquipementMapper;
import tn.esprit.autolocapi.repository.IEquipementRepository;
import tn.esprit.autolocapi.service.IEquipementService;
import tn.esprit.autolocapi.web.dto.EquipementRequest;
import tn.esprit.autolocapi.web.dto.EquipementResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;
    private final EquipementMapper equipementMapper;

    @Override
    public EquipementResponse create(EquipementRequest request) {
        Equipement equipement = equipementMapper.toEntity(request);
        return equipementMapper.toResponse(equipementRepository.save(equipement));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipementResponse> findAll() {
        return equipementRepository.findAll().stream().map(equipementMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EquipementResponse findById(Long id) {
        return equipementMapper.toResponse(getOrThrow(id));
    }

    @Override
    public EquipementResponse update(Long id, EquipementRequest request) {
        Equipement equipement = getOrThrow(id);
        equipementMapper.updateEntity(equipement, request);
        return equipementMapper.toResponse(equipementRepository.save(equipement));
    }

    @Override
    public void delete(Long id) {
        equipementRepository.delete(getOrThrow(id));
    }

    private Equipement getOrThrow(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipement", id));
    }
}
