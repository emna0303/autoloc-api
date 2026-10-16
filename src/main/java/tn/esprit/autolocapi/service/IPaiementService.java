package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement create(Paiement paiement);
    List<Paiement> findAll();
    Paiement findById(Long id);
    Paiement update(Long id, Paiement paiement);
    void delete(Long id);
}