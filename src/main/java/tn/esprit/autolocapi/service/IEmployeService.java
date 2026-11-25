package tn.esprit.autolocapi.service;

import java.util.List;
import tn.esprit.autolocapi.web.dto.EmployeRequest;
import tn.esprit.autolocapi.web.dto.EmployeResponse;

public interface IEmployeService {
    EmployeResponse create(EmployeRequest request);
    List<EmployeResponse> findAll();
    EmployeResponse findById(Long id);
    EmployeResponse update(Long id, EmployeRequest request);
    void delete(Long id);
}
