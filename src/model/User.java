package model;

public class User {
    private int id;
    private String type;
    private String name;
    private boolean isSubscribed;

    public User(int id, String type, String name, boolean isSubscribed) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.isSubscribed = isSubscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public boolean setSubscribed(boolean subscribed) {
        isSubscribed = false;
        return subscribed;
    }
}
