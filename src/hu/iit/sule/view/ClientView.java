package hu.iit.sule.view;

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
    private ClientsEntity selectedClient;

    @ManagedProperty("#{clientService}")
    private ClientServices service;

    @PostConstruct
    public void init(){
        System.out.println("init");
        clients = service.createClients();
       // System.out.println(clients.toString());
    }

    public ArrayList<ClientsEntity> getClients(){
        clients = service.createClients();
        return clients;
    }

    public ClientsEntity getSelectedClient() {
        return selectedClient;
    }

    public void deleteClient(ClientsEntity client){
        System.out.println(client.toString());
        //service.deleteClient(client);
    }

    public String dataClient(ClientsEntity client){
        selectedClient = client;
        getSelectedClientData();
        System.out.println(client.toString());
        return "success?faces-redirect=true";
    }

    public void getSelectedClientData(){
        System.out.println(selectedClient.toString());
    }

    public String backToClients(){
        selectedClient = new ClientsEntity();
        return "client?faces-redirect=true";
    }

    public void editClient(ClientsEntity client){
        System.out.println(client);
    }

    public void setService(ClientServices service){
        this.service = service;
    }
}
