package com.example.project.servives;


import com.example.project.Entity.Client;
import com.example.project.dto.UserDto;

import java.util.List;

public interface ClientService {

    Client getClientByFullname(String nom);

    List<Client> getAllClient();

    Client createClient(UserDto client);

    Client getClientByID(Long id);

    Client updateClient(Client client);

    void deleteClient(long id);




}
