package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.ReservationRequest;
import tn.esprit.autolocapi.web.dto.ReservationResponse;

public interface IReservationService {
    ReservationResponse create(ReservationRequest request);
    List<ReservationResponse> findAll();
    ReservationResponse findById(Long id);
    ReservationResponse update(Long id, ReservationRequest request);
    void delete(Long id);
}
