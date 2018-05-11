package com.example.sharingapp;

/**
 * UserController is responsible for all communication between views and User model
 */
public class UserController {

    private User user;

    public UserController(User user){
        this.user = user;
    }

    public String getId(){
        return user.getId();
    }

    public void setId() {
        user.setId();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public User getUser() {return this.user;}

    public void addObserver(Observer observer) {
        user.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        user.removeObserver(observer);
    }
}
