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
    private MoviesEntity editedMovie = new MoviesEntity();
    private boolean moviesIsEdited = false;
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

    public String selectMovieToedit(MoviesEntity movie){
        moviesIsEdited = true;
        editedMovie = movie;
        return "movies?faces-redirect=true";
    }

    public String saveEditedMovie(){
        service.editMovie(editedMovie);
        editedMovie = new MoviesEntity();
        moviesIsEdited = false;
        return null;
    }

    public void setService(MoviesServices service){
        this.service = service;
    }



    //Getters and Setters
    public void setMovies(ArrayList<MoviesEntity> movies) {
        this.movies = movies;
    }

    public MoviesEntity getEditedMovie() {
        return editedMovie;
    }

    public void setEditedMovie(MoviesEntity editedMovie) {
        this.editedMovie = editedMovie;
    }

    public MoviesEntity getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(MoviesEntity newMovie) {
        this.newMovie = newMovie;
    }

    public boolean isMoviesIsEdited() {
        return moviesIsEdited;
    }

    public void setMoviesIsEdited(boolean moviesIsEdited) {
        this.moviesIsEdited = moviesIsEdited;
    }

    public MoviesServices getService() {
        return service;
    }
}
