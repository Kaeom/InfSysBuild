package hu.iit.sule.dto;

import hu.iit.sule.dataConnect.HibernateUtil;
import hu.iit.sule.model.MoviesEntity;
import hu.iit.sule.model.RentingEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DTORentings {

    private List<RentingEntity> rentings;

    public List<RentingEntity> listAllRenting(){
        rentings = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            rentings = session.createQuery("from RentingEntity ",RentingEntity.class).list();
        }catch(Exception e){
            e.getMessage();
        }
        return rentings;
    }

    public void dateteRenting(RentingEntity renting){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(rentings);
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.getMessage();
        }
    }

}
