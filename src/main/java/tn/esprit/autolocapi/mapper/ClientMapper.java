package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.web.dto.ClientRequest;
import tn.esprit.autolocapi.web.dto.ClientResponse;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequest request) {
        Client client = new Client();
        updateEntity(client, request);
        return client;
    }

    public void updateEntity(Client client, ClientRequest request) {
        client.setNom(request.nom());
        client.setPrenom(request.prenom());
        client.setEmail(request.email());
        client.setTelephone(request.telephone());
        client.setNumPermis(request.numPermis());
        client.setDateInscription(request.dateInscription());
    }

    public ClientResponse toResponse(Client client) {
        return new ClientResponse(
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getEmail(),
                client.getTelephone(),
                client.getNumPermis(),
                client.getDateInscription());
    }
}
