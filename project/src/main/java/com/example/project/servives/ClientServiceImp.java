package com.example.project.servives;

import com.example.project.Entity.Client;
import com.example.project.Exception.ApiRequestException;
import com.example.project.Validator.EmailValidator;
import com.example.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements  ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmailValidator emailValidator;

    @Override
    public Client getClientByNom(String nom) {
        return clientRepository.getClientByNom(nom);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        if (!emailValidator.test(client.getEmail())) {
            throw new ApiRequestException(client.getEmail()+" is not valid");
        }
        System.out.println(clientRepository.existsByEmailLike(client.getEmail()));
        if (clientRepository.existsByEmailLike(client.getEmail())) {
            throw new ApiRequestException(client.getEmail()+" is taken");
        }
        return clientRepository.save(client);
    }

    @Override
    public Client getClientByID(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }


}
