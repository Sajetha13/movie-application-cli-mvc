import model.Movie;
import model.User;
import repository.MovieRepo;
import repository.UserRepo;
import service.MovieService;
import service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MovieRepo movieRepo = new MovieRepo();
        UserRepo userRepo = new UserRepo();
        MovieService movieService = new MovieService(movieRepo, userRepo);
        UserService userService = new UserService(movieRepo, userRepo);

        Movie m1 = new Movie(101, "Star Wars", "Action", 5);
        Movie m2 = new Movie(102, "Avengers", "Fiction", 1);
        Movie m3 = new Movie(103, "Titanic", "Romance", 3);
        Movie m4 = new Movie(104, "Great War", "Sci-Fi", 4);
        movieRepo.save(m1);
        User u1 = new User(1, "viewer", "Saj", false);
        User u2 = new User(2, "viewer", "Hp", true);
        User u3 = new User(3, "admin", "Newt", false);
        User u4 = new User(4, "viewer", "Tim", true);
        User u5 = new User(5, "admin", "Amy", false);


        boolean isRunning=true;
        while(isRunning) {
            System.out.println("HEYYY!!!");
            System.out.println("Welcome to the 1st draft of TMDb, lol");
            System.out.println("=========================================");

            System.out.println("Enter your name to log in!");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Enter your role (viewer/admin)");
            String type = sc.next();
            sc.nextLine();

            if (type.equalsIgnoreCase("viewer")) {
                System.out.println("Alright, you are logged in! Have fun watching a movie!");
            } else {
                System.out.println("Alright, you are logged in! Have fun managing the movie records!");
            }

            boolean log = true;

            while (log) {
                if (type.equalsIgnoreCase("viewer")) {


                    System.out.println("**************************");
                    System.out.println("Navbar");
                    System.out.println("**************************");
                    System.out.println("1. List all Movies");
                    System.out.println("2. Search Movie by Title");
                    System.out.println("3. Filter Movie by Genre");
                    System.out.println("4. View Trending Films");
                    System.out.println("5. Subscribe to our Movie TMDb");
                    System.out.println("6. Log out");
                    System.out.println("7. Sign out");

                    System.out.println("Choose an action to perform: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("List of movies");
                            System.out.println("----------------------");
                            movieService.displayMovies();
                            break;
                        case 2:
                            System.out.println("Enter the Title of the Movie to Search :");
                            String title = sc.next();
                            sc.nextLine();
                            movieService.displayMoviesByTitle(title);
                            break;
                        case 3:
                            System.out.println("Choose the Genre to Filter with >>>");
                            System.out.println("1. Action");
                            System.out.println("2. Romance");
                            System.out.println("3. Fiction");
                            System.out.println("4. Fantasy");
                            System.out.println("5. Sci-Fi");
                            System.out.println("6. Comedy");
                            int genreChoice = sc.nextInt();
                            sc.nextLine();
                            movieService.filterByGenre(genreChoice);
                            break;
                        case 4:
                            System.out.println("Trending Films");
                            System.out.println("------------------------");
                            movieService.displayTrendingFilms();
                            break;
                        case 5:
                            System.out.println("Thanks for subscribing to us :)");
                            System.out.println("You'll get more details abt movies from us now!! yay");
                            userService.doSubsribe(name);
                            break;
                        case 6:
                            System.out.println("Thank you for viewing, Go watch a movie now!!");
                            log=false;
                            break;
                        case 7:
                            isRunning = false;
                            System.out.println("bye bye");
                        default:
                            System.out.println("Enter a valid choice of action");
                    }


                } else if (type.equalsIgnoreCase("admin")) {

                    System.out.println("**************************");
                    System.out.println("Navbar");
                    System.out.println("**************************");
                    System.out.println("1. List all Movies");
                    System.out.println("2. Add a Movie");
                    System.out.println("3. Update Movie Info");
                    System.out.println("4. Delete a Movie");
                    System.out.println("5. View Subscribed Users");
                    System.out.println("6. Log out");
                    System.out.println("7. Sign out");

                    System.out.println("Choose an action to perform: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("List of movies");
                            System.out.println("----------------------");
                            movieService.displayMovies();
                            break;
                        case 2:
                            System.out.println("Operation: Adding a Movie :");
                            System.out.print("Movie id : ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Movie title : ");
                            String title = sc.next();
                            sc.nextLine();
                            System.out.print("Movie genre : ");
                            String genre = sc.next();
                            sc.nextLine();
                            System.out.print("Movie Rank : ");
                            int rank = sc.nextInt();
                            sc.nextLine();

                            MovieService.addMovie(id, title, genre, rank);
                            System.out.println("Movie Added to the TMDb Successfully!");
                            break;
                        case 4:
                            System.out.println("Operation: Deleting a Movie");
                            System.out.print("Enter the ID of the Movie to Delete: ");
                            int delId = sc.nextInt();
                            sc.nextLine();
                            movieService.deleteMovie(delId);
                            System.out.println("Movie Deleted Successfully :(");
                            break;
                        case 5:
                            System.out.println("List of Subscribed Users");
                            System.out.println("-----------------------------");
                            userService.displaySubscribedUsers();
                            break;
                        case 6:
                            System.out.println("Logging off.");
                            log=false;
                            break;
                        case 7:
                            isRunning = false;
                            System.out.println("byee.");
                        default:
                            System.out.println("Enter a valid choice of action");
                    }
                }
            }
        }
    }
}