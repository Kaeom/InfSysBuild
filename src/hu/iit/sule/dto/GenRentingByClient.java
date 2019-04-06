package hu.iit.sule.dto;

import hu.iit.sule.model.ClientsEntity;
import hu.iit.sule.model.MoviesEntity;
import hu.iit.sule.model.RentingByClient;
import hu.iit.sule.model.RentingEntity;

import java.util.ArrayList;
import java.util.List;

public class GenRentingByClient {

    private static List<ClientsEntity> clients;
    private static List<MoviesEntity> movies;
    private static List<RentingEntity> rentings;

    private static List<RentingByClient> rentingByClientList;

    private static void getClients(){
        clients = DTOClients.getAllClient();
    }
    private static void getMovies(){
        movies = DTOMovies.getAllMovie();
    }
    private static void getRentings(){
        rentings = DTORentings.getAllRenting();
    }

    public static List<RentingByClient> genRentings(){

        getClients();
        getMovies();
        getRentings();

        RentingByClient rentingByClient;
        rentingByClientList = new ArrayList<>();
        for (RentingEntity renting: rentings) {
            for(ClientsEntity client: clients){
                for(MoviesEntity movie: movies){
                    if(renting.getClientId() == client.getId() && renting.getMovieID() == movie.getId()){
                        rentingByClient = new RentingByClient(renting.getId(),client.getId(),movie.getId(),movie.getCim(),movie.getDatum(),movie.getSorszam(),movie.getStatus(),movie.getTipus(),renting.getKezdes(),renting.getLejarat());
                        rentingByClientList.add(rentingByClient);
                    }
                }
            }
        }
        return rentingByClientList;
    }

}
