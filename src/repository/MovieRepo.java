package repository;

import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepo {
    public List<Movie> movieList = new ArrayList<>();

    public void save(Movie m){
        movieList.add(m);
    }
}
