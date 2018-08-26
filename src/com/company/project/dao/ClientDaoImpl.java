package com.company.project.dao;

import com.company.project.entity.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {

    private List<Client> clients = new ArrayList<>();


    @Override
    public void saveClient(Client client) {
        System.out.println("Dao, save method execution.");

        clients.add(client);
        System.out.println("Client, saved. ClientId="+client.getId());
    }

    @Override
    public void deleteClient(Client client) {
        System.out.println("Dao, delete method execution.");

        clients.remove(client);
        System.out.println("Client deleted.");

    }

    @Override
    public Client getClient(int id) {

        System.out.println("Dao, get method execution.");

        Optional<Client> first = clients.stream()
                .filter(tmp -> tmp.getId() == id)
                .findFirst();

        if(first.isPresent()){

            Client client = first.get();
            System.out.println("Client found.");
            return client;
        }

        System.out.println("Cant find client with given id~");
        return null;


    }

    @Override
    public List<Client> getAll() {
        System.out.println("Dao, getAll method execution.");
        return new ArrayList<>(clients);
    }
}
