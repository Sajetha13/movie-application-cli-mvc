package service;

import model.User;
import repository.MovieRepo;
import repository.UserRepo;

public class UserService {
    static MovieRepo movieRepo;
    UserRepo userRepo;

    public UserService(MovieRepo movieRepo, UserRepo userRepo) {
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }


    public void doSubsribe(String name){
        for(User s : userRepo.userList){
            if(s.getName().equalsIgnoreCase(name))
                s.setSubscribed(true);
        }
    }

    public void displaySubscribedUsers() {
        boolean found = false;
        for (User s : userRepo.userList) {
            if (s.isSubscribed()) {
                System.out.println(s.getId() + " : " + s.getName() + " (Subscribed)");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No User has Subscribed yet.");
        }
    }
}
