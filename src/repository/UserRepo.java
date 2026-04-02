package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    public static List<User> userList = new ArrayList<>();

    public void save(User u){
        userList.add(u);
    }
}
