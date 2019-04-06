package hu.iit.sule.dto;

import hu.iit.sule.dataConnect.HibernateUtil;
import hu.iit.sule.model.ClientsEntity;
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

    private static List<MoviesEntity> movies;
    private static Calendar calendar = Calendar.getInstance();
    private static java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

    public static List<MoviesEntity> getAllMovie(){
        movies = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            movies = session.createQuery("from MoviesEntity ",MoviesEntity.class).list();
        }catch (Exception e){
            System.out.println("DTOMovies message: "+e.getMessage());
        }
        return movies;
    }

    public static void addMovieToDatabase(MoviesEntity movie){
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

    public static void deleteMovie(MoviesEntity movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            MoviesEntity deleteMovie = (MoviesEntity)session.load(MoviesEntity.class,movie.getId());
            session.delete(deleteMovie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Movie delete exception: " + e.getMessage());
        }
    }

    public static void editMovie(MoviesEntity movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(movie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("movie delete exception: " + e.getMessage());
        }
    }

    public static void setMovieToRented(int movieID){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            MoviesEntity updatedmovie = (MoviesEntity)session.load(MoviesEntity.class,movieID);
            updatedmovie.setStatus("Rented");
            session.update(updatedmovie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("movie status update exception: " + e.getMessage());
        }
    }
    public static void setMovieToAvailable(int movieID){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            MoviesEntity updatedmovie = (MoviesEntity)session.load(MoviesEntity.class,movieID);
            updatedmovie.setStatus("Available");
            session.update(updatedmovie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("movie status update exception: " + e.getMessage());
        }
    }

}
