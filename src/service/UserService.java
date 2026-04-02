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

    public void displaySubscribedUsers(){
        boolean found = false;
        for(User s : userRepo.userList){
            if (s.setSubscribed(true)) {
                System.out.println(s.getId()+" : "+s.getName()+" ("+((s.isSubscribed()) ?  "Subscribed" : "Not Subsribed")+")");
                found = true;
            }
        }
        if(found == false){
            System.out.println("No User has Subscribed");
        }
    }
}
