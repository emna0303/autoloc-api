package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.PaiementMapper;
import tn.esprit.autolocapi.repository.IPaiementRepository;
import tn.esprit.autolocapi.service.IPaiementService;
import tn.esprit.autolocapi.web.dto.PaiementResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public List<PaiementResponse> findAll() {
        return paiementRepository.findAll().stream().map(paiementMapper::toResponse).toList();
    }

    @Override
    public PaiementResponse findById(Long id) {
        return paiementRepository.findById(id)
                .map(paiementMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement", id));
    }
}
