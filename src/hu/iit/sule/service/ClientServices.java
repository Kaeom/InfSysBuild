package hu.iit.sule.service;

import hu.iit.sule.dto.DTOClients;
import hu.iit.sule.model.Client;
import hu.iit.sule.model.ClientsEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name = "clientService")
@ApplicationScoped
public class ClientServices {

    private ArrayList<ClientsEntity> clients;
    DTOClients dtoClients = new DTOClients();

    public ArrayList<ClientsEntity> createClients(){
        clients = (ArrayList<ClientsEntity>) dtoClients.getClients();
        return clients;
    }

    public void deleteClient(ClientsEntity client){
        dtoClients.deleteClient(client);
    }
}
