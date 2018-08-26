package com.company.project.dao;

import com.company.project.entity.Client;

import java.util.List;

public interface ClientDao {

    void saveClient(Client client);

    void deleteClient(Client client);

    Client getClient(int id);

    List<Client> getAll();

}
