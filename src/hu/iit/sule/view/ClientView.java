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

    DTOClients dtoClients = new DTOClients();

    @ManagedProperty("#{clientsServices}")
    private ClientServices services;

//    @PostConstruct
//    public void init(){
//        System.out.println("init");
//        clients = service.createClients();
//       // System.out.println(clients.toString());
//    }

    public ArrayList<ClientsEntity> getClients(){
        clients = (ArrayList<ClientsEntity>) dtoClients.listAllClient();
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

    public void setServices(ClientServices services){
        this.services = services;
    }
}
