package com.example.project.servives;

import com.example.project.Entity.Client;
import com.example.project.Entity.User;
import com.example.project.Exception.ApiRequestException;
import com.example.project.Validator.EmailValidator;
import com.example.project.dto.UserDto;
import com.example.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class ClientServiceImp implements  ClientService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmailValidator emailValidator;

    @Override
    public Client getClientByFullname(String nom) {
        return clientRepository.getClientByFullname(nom);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(UserDto user) {
        if (!emailValidator.test(user.getEmail())) {
            throw new ApiRequestException("Email is not valid");
        }

        if (clientRepository.existsByEmailLike(user.getEmail())) {
            throw new ApiRequestException("Email is already taken");
        }

        if (clientRepository.existsByUsernameLike(user.getUsername())) {
            throw new ApiRequestException("Username is already taken");
        }

        Client client = new Client(user.getUsername(), user.getEmail(), passwordEncoder.encode(user.getPassword()) , user.getRole(), user.getFullname());
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
