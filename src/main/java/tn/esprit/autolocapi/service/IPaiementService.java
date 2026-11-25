package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.PaiementResponse;

public interface IPaiementService {
    List<PaiementResponse> findAll();
    PaiementResponse findById(Long id);
}
