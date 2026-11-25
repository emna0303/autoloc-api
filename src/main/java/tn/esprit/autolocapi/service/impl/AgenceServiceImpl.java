package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.AgenceMapper;
import tn.esprit.autolocapi.repository.IAgenceRepository;
import tn.esprit.autolocapi.service.IAgenceService;
import tn.esprit.autolocapi.web.dto.AgenceRequest;
import tn.esprit.autolocapi.web.dto.AgenceResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    @Override
    public AgenceResponse create(AgenceRequest request) {
        Agence agence = agenceMapper.toEntity(request);
        return agenceMapper.toResponse(agenceRepository.save(agence));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgenceResponse> findAll() {
        return agenceRepository.findAll().stream().map(agenceMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AgenceResponse findById(Long id) {
        return agenceMapper.toResponse(getOrThrow(id));
    }

    @Override
    public AgenceResponse update(Long id, AgenceRequest request) {
        Agence agence = getOrThrow(id);
        agenceMapper.updateEntity(agence, request);
        return agenceMapper.toResponse(agenceRepository.save(agence));
    }

    @Override
    public void delete(Long id) {
        agenceRepository.delete(getOrThrow(id));
    }

    private Agence getOrThrow(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", id));
    }
}
