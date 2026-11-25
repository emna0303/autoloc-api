package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.ContratMapper;
import tn.esprit.autolocapi.repository.IContratRepository;
import tn.esprit.autolocapi.repository.IReservationRepository;
import tn.esprit.autolocapi.service.IContratService;
import tn.esprit.autolocapi.web.dto.ContratRequest;
import tn.esprit.autolocapi.web.dto.ContratResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;
    private final IReservationRepository reservationRepository;
    private final ContratMapper contratMapper;

    @Override
    public ContratResponse create(ContratRequest request) {
        Contrat contrat = contratMapper.toEntity(request);
        contrat.setReservation(findReservation(request.reservationId()));
        return contratMapper.toResponse(contratRepository.save(contrat));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratResponse> findAll() {
        return contratRepository.findAll().stream().map(contratMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ContratResponse findById(Long id) {
        return contratMapper.toResponse(getOrThrow(id));
    }

    @Override
    public ContratResponse update(Long id, ContratRequest request) {
        Contrat contrat = getOrThrow(id);
        contratMapper.updateEntity(contrat, request);
        contrat.setReservation(findReservation(request.reservationId()));
        return contratMapper.toResponse(contratRepository.save(contrat));
    }

    @Override
    public void delete(Long id) {
        contratRepository.delete(getOrThrow(id));
    }

    private Contrat getOrThrow(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", id));
    }

    private Reservation findReservation(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", reservationId));
    }
}
