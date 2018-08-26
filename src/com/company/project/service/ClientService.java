package com.company.project.service;

import com.company.project.entity.Client;

import java.util.List;

public interface ClientService {


    Client getClient(int id);

    List<Client> getAll();

    List<Client> getSortedByIdClients();

    void deleteClient(Client client);

    void saveClient(Client client);


}
