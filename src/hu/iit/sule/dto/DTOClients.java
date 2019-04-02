package hu.iit.sule.dto;
import hu.iit.sule.dataConnect.HibernateUtil;
import hu.iit.sule.model.ClientsEntity;
import hu.iit.sule.model.MoviesEntity;
import hu.iit.sule.model.RentingEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DTOClients {

    private List<ClientsEntity> clients;
    private List<MoviesEntity> movies;

    public List<ClientsEntity> getClients(){
        clients = new ArrayList<>();
        ClientsEntity client1 = new ClientsEntity("Név1","Tel1","Szig1","Lakcim1");
        ClientsEntity client2 = new ClientsEntity("Név2","Tel2","Szig2","Lakcim2");
        ClientsEntity client3 = new ClientsEntity("Név3","Tel3","Szig3","Lakcim3");
        ClientsEntity client4 = new ClientsEntity("Név4","Tel4","Szig4","Lakcim4");
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        return clients;
    }

    public List<ClientsEntity> listAllClient(){
        clients = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            clients = session.createQuery("from ClientsEntity ", ClientsEntity.class).list();

        }catch (Exception e){
            System.out.println(e.getMessage()+"DTOClients Message");
        }
        return clients;
    }

    public void addClientToDatabase(ClientsEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Add Client Exception, Message: " + e.getMessage());
        }
    }

    public void deleteClient(ClientsEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            ClientsEntity deletedClient = (ClientsEntity)session.load(ClientsEntity.class,client.getId());
            System.out.println("törlendő kliens: " + deletedClient.toString());
            session.delete(deletedClient);
            transaction.commit();
            System.out.println("kliens törölve");
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Client delete exception: " + e.getMessage());
        }
    }


}
