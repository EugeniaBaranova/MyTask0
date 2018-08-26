package com.company.project.service;

import com.company.project.dao.ClientDao;
import com.company.project.dao.ClientDaoImpl;
import com.company.project.entity.Client;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao dao){
        clientDao = dao;
    }

    @Override
    public Client getClient(int id) {

        System.out.println("Service, getMethod.");
        return clientDao.getClient(id);
    }

    @Override
    public List<Client> getAll() {
        System.out.println("Service getAll method");
        return clientDao.getAll();
    }

    @Override
    public List<Client> getSortedByIdClients() {
        System.out.println("Service getSortedById method.");
        List<Client> all = clientDao.getAll();
        List<Client> result = all.stream().sorted(Comparator.comparingInt(Client::getId))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void deleteClient(Client client) {

        System.out.println("Service delete method.");
        clientDao.deleteClient(client);
    }

    @Override
    public void saveClient(Client client) {

        int id = client.getName().length() + client.getSecondName().length();
        client.setId(id);
        clientDao.saveClient(client);
        System.out.println("Service save method.");
    }


    private ClientDao getClientDao() {
        return clientDao;
    }
}
