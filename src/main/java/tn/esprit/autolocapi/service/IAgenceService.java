package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.AgenceRequest;
import tn.esprit.autolocapi.web.dto.AgenceResponse;

public interface IAgenceService {
    AgenceResponse create(AgenceRequest request);
    List<AgenceResponse> findAll();
    AgenceResponse findById(Long id);
    AgenceResponse update(Long id, AgenceRequest request);
    void delete(Long id);
}
