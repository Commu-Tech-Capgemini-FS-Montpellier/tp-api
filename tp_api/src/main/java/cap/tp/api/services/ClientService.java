package cap.tp.api.services;

import cap.tp.api.client.ZipCodeClient;
import cap.tp.api.entities.Client;
import cap.tp.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ZipCodeClient zipCodeClient;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        this.zipCodeClient = new ZipCodeClient();
    }

    public List<Client> getAllClients() {
        var clients = clientRepository.findAll();
        clients.stream().filter(Objects::nonNull).forEach(codePostal->codePostal.setZipCodeClient(zipCodeClient.getCommune(codePostal.getZipCodeClient())));
        return clients;
    }

    public List<Client> getAllClientsWithPagination(int page, int rows) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll(PageRequest.of(page,rows)).forEach(clients::add);
        clients.stream().filter(Objects::nonNull).forEach(codePostal->codePostal.setZipCodeClient(zipCodeClient.getCommune(codePostal.getZipCodeClient())));
        return clients;
    }
}
