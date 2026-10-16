package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Contrat;

import java.util.List;

public interface IContratService {
    Contrat create(Contrat contrat);
    List<Contrat> findAll();
    Contrat findById(Long id);
    Contrat update(Long id, Contrat contrat);
    void delete(Long id);
}
