package hu.iit.sule.service;

import hu.iit.sule.dto.DTOClients;
import hu.iit.sule.dto.DTOMovies;
import hu.iit.sule.dto.DTORentings;
import hu.iit.sule.dto.GenRentingByClient;
import hu.iit.sule.model.ClientsEntity;
import hu.iit.sule.model.MoviesEntity;
import hu.iit.sule.model.RentingByClient;
import hu.iit.sule.model.RentingEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name="clientsServices")
@ApplicationScoped
public class ClientServices {

    public ArrayList<ClientsEntity> getClients(){
        ArrayList<ClientsEntity> clients = (ArrayList<ClientsEntity>) DTOClients.getAllClient();
        return clients;
    }

    public ArrayList<RentingByClient> getRentingByClient(ClientsEntity client){
        ArrayList<RentingByClient> rentingByClients = (ArrayList<RentingByClient>) GenRentingByClient.genRentings();
        ArrayList<RentingByClient> rentingBySelectedClient = new ArrayList<>();

        for(RentingByClient rentingByClient: rentingByClients){
            if(rentingByClient.getClientID() == client.getId()){
                rentingBySelectedClient.add(rentingByClient);
            }
        }
        return rentingBySelectedClient;
    }

    public void addClient(ClientsEntity client){
        DTOClients.addClientToDatabase(client);
    }

    public void deleteClient(ClientsEntity client){
        DTOClients.deleteClient(client);
    }

    public void editClient(ClientsEntity client) { DTOClients.editClient(client);}

    public void saveRetings(MoviesEntity movie, ClientsEntity selectedClient){
        RentingEntity renting;
        Date date = new Date();
        renting = new RentingEntity(selectedClient.getId(),movie.getId(),date,date);
        DTORentings.addRentingToDatabase(renting);
        DTOMovies.setMovieToRented(movie.getId());

    }
    public void deleteRenting(RentingByClient renting){
        DTORentings.dateRenting(renting.getId());
        DTOMovies.setMovieToAvailable(renting.getMovieID());
    }
}
