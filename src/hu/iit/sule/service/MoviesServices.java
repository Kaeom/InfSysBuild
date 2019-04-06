package hu.iit.sule.service;


import hu.iit.sule.dto.DTOMovies;
import hu.iit.sule.dto.GenRentingByClient;
import hu.iit.sule.model.MoviesEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name="moviesServices")
@ApplicationScoped
public class MoviesServices {
    private ArrayList<MoviesEntity> movies;

    public ArrayList<MoviesEntity> getMovies(){
        movies = (ArrayList<MoviesEntity>) DTOMovies.getAllMovie();
//        System.out.println("MoviesService.createMovies"+movies.toString());
//        System.out.println("Generated data: " + GenRentingByClient.genRentings().toString());
        return movies;
    }
    public void addMovie(MoviesEntity movie){
        System.out.println("Debug: Movies Services addMovie: " + movie.toString());
        DTOMovies.addMovieToDatabase(movie);
    }
    public void deleteMovie(MoviesEntity movie){
        DTOMovies.deleteMovie(movie);
    }

    public void editMovie(MoviesEntity movie){
        DTOMovies.editMovie(movie);
    }
}
