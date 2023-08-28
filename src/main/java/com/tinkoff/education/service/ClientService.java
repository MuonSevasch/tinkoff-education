package com.tinkoff.education.service;

import com.tinkoff.education.domain.Client;
import com.tinkoff.education.domain.ClientCar;
import com.tinkoff.education.domain.Car;
import com.tinkoff.education.repository.ClientRepository;
import com.tinkoff.education.repository.ClientCarRepository;
import com.tinkoff.education.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final ClientCarRepository clientCarRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Integer clientId, Client client) {
        Optional<Client> existingClient = clientRepository.findById(clientId);
        if (existingClient.isPresent()) {
            Client updatedClient = existingClient.get();
            updatedClient.setFullName(client.getFullName());
            updatedClient.setCity(client.getCity());
            return clientRepository.save(updatedClient);
        } else {
            return null;
        }
    }

    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client addCarToClient(Integer clientId, Car car) {
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {
            Car savedCar = carRepository.save(car);
            ClientCar clientCar = new ClientCar();
            clientCar.setClient(client);
            clientCar.setCar(savedCar);
            clientCarRepository.save(clientCar);
            return client;
        } else {
            return null;
        }
    }
}
