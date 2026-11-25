package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.ContratRequest;
import tn.esprit.autolocapi.web.dto.ContratResponse;

public interface IContratService {
    ContratResponse create(ContratRequest request);
    List<ContratResponse> findAll();
    ContratResponse findById(Long id);
    ContratResponse update(Long id, ContratRequest request);
    void delete(Long id);
}
