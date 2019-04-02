package hu.iit.sule.service;


import hu.iit.sule.dto.DTOMovies;
import hu.iit.sule.model.MoviesEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name="moviesServices")
@ApplicationScoped
public class MoviesServices {
    private ArrayList<MoviesEntity> movies;
    DTOMovies dtoMovies = new DTOMovies();

    public ArrayList<MoviesEntity> getMovies(){
        movies = (ArrayList<MoviesEntity>) dtoMovies.listAllMovie();
        System.out.println("MoviesService.createMovies"+movies.toString());
        return movies;
    }
    public void addMovie(MoviesEntity movie){
        System.out.println("Debug: Movies Services addMovie: " + movie.toString());
        dtoMovies.addMovieToDatabase(movie);
    }
    public void deleteMovie(MoviesEntity movie){
        dtoMovies.deleteMovie(movie);
    }
}
