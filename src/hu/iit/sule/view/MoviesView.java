package hu.iit.sule.view;


import hu.iit.sule.model.MoviesEntity;
import hu.iit.sule.service.MoviesServices;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="moviesView")
@ViewScoped
public class MoviesView implements Serializable {

    private ArrayList<MoviesEntity> movies;
    private MoviesEntity selectedMovie;
    private MoviesEntity newMovie;
    private boolean edit = false;

    @ManagedProperty("#{moviesServices}")
    private MoviesServices service;

    public ArrayList<MoviesEntity> getMovies(){
        movies = service.getMovies();
        return movies;
    }
    public MoviesEntity getSelectedMovie(){
        return selectedMovie;
    }

    public void addMovie(MoviesEntity moviesEntity){
        System.out.println("MovieView: " + newMovie.toString());
        //service.addMovie(newMovie);
        edit = false;
    }

    public void setService(MoviesServices service){
        this.service = service;
    }

    public boolean isEdit() {
        return this.edit;
    }

    public MoviesEntity getNewMovie() {
        return newMovie;
    }
}
