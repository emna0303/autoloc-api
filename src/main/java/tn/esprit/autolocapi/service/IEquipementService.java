package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement create(Equipement equipement);
    List<Equipement> findAll();
    Equipement findById(Long id);
    Equipement update(Long id, Equipement equipement);
    void delete(Long id);
}