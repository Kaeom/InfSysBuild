package hu.iit.sule.view;


import hu.iit.sule.model.MoviesEntity;
import hu.iit.sule.service.MoviesServices;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="moviesView")
@SessionScoped
public class MoviesView implements Serializable {

    private ArrayList<MoviesEntity> movies;
    private MoviesEntity selectedMovie;
    private MoviesEntity newMovie = new MoviesEntity();

    @ManagedProperty("#{moviesServices}")
    private MoviesServices service;

    public ArrayList<MoviesEntity> getMovies(){
        movies = service.getMovies();
        return movies;
    }

    public String addMovie(){
        service.addMovie(newMovie);
        newMovie = new MoviesEntity();
        return "movies";
    }

    public String deleteMovie(MoviesEntity movie){
        service.deleteMovie(movie);
        return "movies?faces-redirect=true";
    }

    public void setService(MoviesServices service){
        this.service = service;
    }



    //Getters and Setters
    public void setMovies(ArrayList<MoviesEntity> movies) {
        this.movies = movies;
    }

    public MoviesEntity getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(MoviesEntity selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public MoviesEntity getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(MoviesEntity newMovie) {
        this.newMovie = newMovie;
    }
}
