package hu.iit.sule.dto;

import hu.iit.sule.dataConnect.HibernateUtil;
import hu.iit.sule.model.MoviesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

public class DTOMovies {

    private List<MoviesEntity> movies;
    Calendar calendar = Calendar.getInstance();
    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

    public List<MoviesEntity> getMovies(){
        movies = new ArrayList<>();
        MoviesEntity movie1 = new MoviesEntity("Cim1",date,"001","Kölcsönözhető","DVD");
        MoviesEntity movie2 = new MoviesEntity("Cim2",date,"001","Kölcsönözhető","DVD");
        MoviesEntity movie3 = new MoviesEntity("Cim3",date,"001","Kölcsönözhető","DVD");
        MoviesEntity movie4 = new MoviesEntity("Cim4",date,"001","Kölcsönözhető","DVD");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        return movies;
    }

    public List<MoviesEntity> listAllMovie(){
        System.out.println("Mi a faszért fut ez amikor nem kénen neki???????????");
        movies = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            movies = session.createQuery("from MoviesEntity ",MoviesEntity.class).list();
        }catch (Exception e){
            System.out.println("DTOMovies message: "+e.getMessage());
        }
        return movies;
    }

    public void addMovieToDatabase(MoviesEntity movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Add Movie Exception, Message: " + e.getMessage());
        }
    }

}
