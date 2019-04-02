package hu.iit.sule.view;

import hu.iit.sule.dto.DTOClients;
import hu.iit.sule.model.ClientsEntity;
import hu.iit.sule.service.ClientServices;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="clientView")
@SessionScoped
public class ClientView implements Serializable {

    private ArrayList<ClientsEntity> clients;
    private ClientsEntity selectedClient;
    private ClientsEntity newClient = new ClientsEntity();

    @ManagedProperty("#{clientsServices}")
    private ClientServices services;

    public ArrayList<ClientsEntity> getClients(){
        clients = services.getClients();
        return clients;
    }

    public String addClient(){
        services.addClient(newClient);
        newClient = new ClientsEntity();
        return "clients";
    }

    public String deleteClient(ClientsEntity client){
        System.out.println(client.toString());
        services.deleteClient(client);
        return "clients?faces-redirect=true";
    }

    public String dataClient(ClientsEntity client){
        selectedClient = client;
        getSelectedClientData();
        System.out.println(client.toString());
        return "client_data?faces-redirect=true";
    }

    public void getSelectedClientData(){
        System.out.println(selectedClient.toString());
    }

    public void editClient(ClientsEntity client){
        System.out.println(client);
    }

    public void setServices(ClientServices services){
        this.services = services;
    }


    //Getters and Setters

    public void setClients(ArrayList<ClientsEntity> clients) {
        this.clients = clients;
    }

    public ClientServices getServices() {
        return services;
    }

    public void setSelectedClient(ClientsEntity selectedClient) {
        this.selectedClient = selectedClient;
    }

    public ClientsEntity getSelectedClient() {
        return selectedClient;
    }

    public ClientsEntity getNewClient() {
        return newClient;
    }

    public void setNewClient(ClientsEntity newClient) {
        this.newClient = newClient;
    }
}
