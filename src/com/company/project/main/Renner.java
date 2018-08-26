package com.company.project.main;

import com.company.project.dao.ClientDaoImpl;
import com.company.project.dao.ClientDbDaoImpl;
import com.company.project.entity.Client;
import com.company.project.service.ClientService;
import com.company.project.service.ClientServiceImpl;

import java.util.List;

public class Renner {


    private ClientService clientService;


    public static void main(String[] args) {

        ClientService service = new ClientServiceImpl(new ClientDaoImpl());

        Client client = new Client();
        client.setName("CliengftName");
        client.setSecondName("ClinetSecondName");
        service.saveClient(client);


        System.out.println(service.getAll());


        service.deleteClient(client);


        System.out.println(service.getAll());

    }
}
