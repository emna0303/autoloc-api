package tn.esprit.autolocapi.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.ClientMapper;
import tn.esprit.autolocapi.repository.IClientRepository;
import tn.esprit.autolocapi.service.IClientService;
import tn.esprit.autolocapi.web.dto.ClientRequest;
import tn.esprit.autolocapi.web.dto.ClientResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse create(ClientRequest request) {
        Client client = clientMapper.toEntity(request);
        return clientMapper.toResponse(clientRepository.save(client));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponse> findAll() {
        return clientRepository.findAll().stream().map(clientMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponse findById(Long id) {
        return clientMapper.toResponse(getOrThrow(id));
    }

    @Override
    public ClientResponse update(Long id, ClientRequest request) {
        Client client = getOrThrow(id);
        clientMapper.updateEntity(client, request);
        return clientMapper.toResponse(clientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(getOrThrow(id));
    }

    private Client getOrThrow(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
    }
}
