package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Employe;

import java.util.List;

public interface IEmployeService {
    Employe create(Employe employe);
    List<Employe> findAll();
    Employe findById(Long id);
    Employe update(Long id, Employe employe);
    void delete(Long id);
}