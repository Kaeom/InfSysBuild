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

    private static List<ClientsEntity> clients;

    public static List<ClientsEntity> getAllClient(){
        clients = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            clients = session.createQuery("from ClientsEntity ", ClientsEntity.class).list();

        }catch (Exception e){
            System.out.println(e.getMessage()+"DTOClients Message");
        }
        return clients;
    }

    public static void addClientToDatabase(ClientsEntity client){
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

    public static void deleteClient(ClientsEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            ClientsEntity deletedClient = (ClientsEntity)session.load(ClientsEntity.class,client.getId());
            session.delete(deletedClient);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Client delete exception: " + e.getMessage());
        }
    }

    public static void editClient(ClientsEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Client delete exception: " + e.getMessage());
        }
    }


}
