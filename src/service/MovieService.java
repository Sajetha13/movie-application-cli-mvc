package service;

import model.Movie;
import repository.MovieRepo;
import repository.UserRepo;

public class MovieService {
    static MovieRepo movieRepo;
    UserRepo userRepo;

    public MovieService(MovieRepo movieRepo, UserRepo userRepo) {
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }

    public String displayMovies(){
        if(movieRepo.movieList.isEmpty()){
            System.out.println("Sorry no movies are available now");
        }
        for(Movie m : movieRepo.movieList){
            System.out.println(m.getId()+"\n"+m.getTitle()+" : "+m.getGenre());
        }
        return null;
    }

    public void displayMoviesByTitle(String title){
        if(movieRepo.movieList.isEmpty()){
            System.out.println("Sorry no movies are available now");
        }
        //if title not available in the list

        for(Movie m: movieRepo.movieList){
            if(m.getTitle().equalsIgnoreCase(title)){
                System.out.println(m.getId()+"\n"+m.getTitle()+" : "+m.getGenre());
            }
            else{
                System.out.println("No movie available in that provided title");
            }
        }
    }
    public void filterByGenre(int genre_choice){
        String genre = "";
        switch (genre_choice) {
            case 1: genre = "action"; break;
            case 2: genre = "romance"; break;
            case 3: genre = "fiction"; break;
            case 4: genre = "fantasy"; break;
            case 5: genre = "sci-fi"; break;
            case 6: genre = "comedy"; break;
        }

        boolean found = false;
        for (Movie m : movieRepo.movieList) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(m.getId()+"\n"+m.getTitle());
                found = true;
            }
        }
        if(!found){
            System.out.println("No movies are under the genre '"+genre+"'");
        }
    }

    public void displayTrendingFilms(){
        if(movieRepo.movieList.isEmpty()){
            System.out.println("Sorry no movies are available now");
        }
        for(Movie m : movieRepo.movieList){
            if(m.getRankNumber()>=1 || m.getRankNumber()<=10){
                System.out.println(m.getRankNumber()+" : "+m.getTitle()+"  ("+m.getGenre()+")");
            }
        }
    }

    //admin services:

    public static void addMovie(int id, String title, String genre, int rank){
        for(Movie m : movieRepo.movieList){
            if(m.getId() == id) {
                System.out.println("Error: Movie ID " + id + " already exists in TMDb!");
                return;
            }
        }
        Movie newMovie = new Movie(id, title, genre, rank);
        movieRepo.save(newMovie);
        System.out.println("Movie '" + title + "' added successfully!");
    }

    public void deleteMovie(int id) {
        Movie found = null;
        for (Movie m : movieRepo.movieList) {
            if (m.getId() == id) {
                found = m;
                break;
            }
        }
        if (found != null) {
            movieRepo.movieList.remove(found);
            System.out.println("Movie Deleted Successfully :(");
        } else {
            System.out.println("There is no Movie with the id: " + id);
        }
    }
}
