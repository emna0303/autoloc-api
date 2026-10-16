package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    List<Client> findAll();
    Client findById(Long id);
    Client update(Long id, Client client);
    void delete(Long id);
}