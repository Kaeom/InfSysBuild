package hu.iit.sule.dto;
import hu.iit.sule.dataConnect.HibernateUtil;
import hu.iit.sule.model.ClientsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DTOClients {

    private List<ClientsEntity> clients;

    public List<ClientsEntity> getClients(){
        clients = new ArrayList<>();
        ClientsEntity client1 = new ClientsEntity("Név1","Tel1","Szig1","Lakcim1",(byte)1);
        ClientsEntity client2 = new ClientsEntity("Név2","Tel2","Szig2","Lakcim2",(byte)1);
        ClientsEntity client3 = new ClientsEntity("Név3","Tel3","Szig3","Lakcim3",(byte)1);
        ClientsEntity client4 = new ClientsEntity("Név4","Tel4","Szig4","Lakcim4",(byte)1);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        return clients;
    }

    public List<ClientsEntity> listAllClient(){
        Transaction transaction = null;
        List<ClientsEntity> clientsEntities = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            clientsEntities = session.createQuery("from ClientsEntity ", ClientsEntity.class).list();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return clientsEntities;
    }


    public void deleteClient(ClientsEntity client){
        clients.remove(client);
    }


}
