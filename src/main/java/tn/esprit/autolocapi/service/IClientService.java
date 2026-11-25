package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.ClientRequest;
import tn.esprit.autolocapi.web.dto.ClientResponse;

public interface IClientService {
    ClientResponse create(ClientRequest request);
    List<ClientResponse> findAll();
    ClientResponse findById(Long id);
    ClientResponse update(Long id, ClientRequest request);
    void delete(Long id);
}
