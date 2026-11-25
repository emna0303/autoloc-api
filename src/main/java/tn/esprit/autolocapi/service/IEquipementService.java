package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.EquipementRequest;
import tn.esprit.autolocapi.web.dto.EquipementResponse;

public interface IEquipementService {
    EquipementResponse create(EquipementRequest request);
    List<EquipementResponse> findAll();
    EquipementResponse findById(Long id);
    EquipementResponse update(Long id, EquipementRequest request);
    void delete(Long id);
}
