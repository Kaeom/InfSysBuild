package hu.iit.sule.service;

import hu.iit.sule.dto.DTOClients;
import hu.iit.sule.dto.DTOMovies;
import hu.iit.sule.model.ClientsEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name="clientsServices")
@ApplicationScoped
public class ClientServices {
    private ArrayList<ClientsEntity> clients;
    DTOClients dtoClients = new DTOClients();

    public ArrayList<ClientsEntity> getClients(){
        clients = (ArrayList<ClientsEntity>) dtoClients.listAllClient();
        return clients;
    }

    public void addClient(ClientsEntity client){
        dtoClients.addClientToDatabase(client);
    }
}
