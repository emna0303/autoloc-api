package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.ReservationMapper;
import tn.esprit.autolocapi.repository.IClientRepository;
import tn.esprit.autolocapi.repository.IReservationRepository;
import tn.esprit.autolocapi.repository.IVehiculeRepository;
import tn.esprit.autolocapi.service.IReservationService;
import tn.esprit.autolocapi.web.dto.ReservationRequest;
import tn.esprit.autolocapi.web.dto.ReservationResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final IClientRepository clientRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationResponse create(ReservationRequest request) {
        Reservation reservation = reservationMapper.toEntity(request);
        remplirRelations(reservation, request);
        return reservationMapper.toResponse(reservationRepository.save(reservation));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll().stream().map(reservationMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReservationResponse findById(Long id) {
        return reservationMapper.toResponse(getOrThrow(id));
    }

    @Override
    public ReservationResponse update(Long id, ReservationRequest request) {
        Reservation reservation = getOrThrow(id);
        reservationMapper.updateEntity(reservation, request);
        remplirRelations(reservation, request);
        return reservationMapper.toResponse(reservationRepository.save(reservation));
    }

    @Override
    public void delete(Long id) {
        reservationRepository.delete(getOrThrow(id));
    }

    private Reservation getOrThrow(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    }

    // Loads the vehicule and the client from their ids and links them to the reservation.
    private void remplirRelations(Reservation reservation, ReservationRequest request) {
        Vehicule vehicule = vehiculeRepository.findById(request.vehiculeId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", request.vehiculeId()));
        Client client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", request.clientId()));
        reservation.setVehicule(vehicule);
        reservation.setClient(client);
    }
}
