package com.company.project.dao;

import com.company.project.entity.Client;

import java.util.List;

public class ClientDbDaoImpl implements ClientDao {
    @Override
    public void saveClient(Client client) {
        System.out.println("Dao saved in db.");
    }

    @Override
    public void deleteClient(Client client) {
        System.out.println("Dao deleted from db.");
    }

    @Override
    public Client getClient(int id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }
}
