package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation create(Reservation reservation);
    List<Reservation> findAll();
    Reservation findById(Long id);
    Reservation update(Long id, Reservation reservation);
    void delete(Long id);
}