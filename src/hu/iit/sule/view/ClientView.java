package hu.iit.sule.view;

import hu.iit.sule.model.Client;
import hu.iit.sule.model.ClientsEntity;
import hu.iit.sule.service.ClientServices;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="clientView")
@ViewScoped
public class ClientView implements Serializable {

    private ArrayList<ClientsEntity> clients;

    @ManagedProperty("#{clientService}")
    private ClientServices service;

    @PostConstruct
    public void init(){
        System.out.println("init");
        clients = service.createClients();
        System.out.println(clients.toString());
    }

    public ArrayList<ClientsEntity> getClients(){
        return clients;
    }

    public void deleteClient(ClientsEntity client){
        System.out.println(client);
        service.deleteClient(client);
    }

    public void editClient(Client client){
        System.out.println(client);
    }

    public void setService(ClientServices service){
        this.service = service;
    }
}
