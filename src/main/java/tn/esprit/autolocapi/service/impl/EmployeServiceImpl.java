package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.EmployeMapper;
import tn.esprit.autolocapi.repository.IAgenceRepository;
import tn.esprit.autolocapi.repository.IEmployeRepository;
import tn.esprit.autolocapi.service.IEmployeService;
import tn.esprit.autolocapi.web.dto.EmployeRequest;
import tn.esprit.autolocapi.web.dto.EmployeResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;
    private final EmployeMapper employeMapper;

    @Override
    public EmployeResponse create(EmployeRequest request) {
        Employe employe = employeMapper.toEntity(request);
        employe.setAgence(findAgence(request.agenceId()));
        return employeMapper.toResponse(employeRepository.save(employe));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeResponse> findAll() {
        return employeRepository.findAll().stream().map(employeMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeResponse findById(Long id) {
        return employeMapper.toResponse(getOrThrow(id));
    }

    @Override
    public EmployeResponse update(Long id, EmployeRequest request) {
        Employe employe = getOrThrow(id);
        employeMapper.updateEntity(employe, request);
        employe.setAgence(findAgence(request.agenceId()));
        return employeMapper.toResponse(employeRepository.save(employe));
    }

    @Override
    public void delete(Long id) {
        employeRepository.delete(getOrThrow(id));
    }

    private Employe getOrThrow(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", id));
    }

    private Agence findAgence(Long agenceId) {
        return agenceRepository.findById(agenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", agenceId));
    }
}
