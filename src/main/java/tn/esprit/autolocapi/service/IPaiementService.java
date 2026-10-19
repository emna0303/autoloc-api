package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.domain.Paiement;

public interface IPaiementService {
    List<Paiement> findAll();
    Paiement findById(Long id);
}