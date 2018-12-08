package com.ics115_project.cookbook;

public class User {
    String userEmail;
    String userName;
    int userAccountType;

    public User(){

    }

    public User(String userEmail, String userName, int userAccountType) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAccountType = userAccountType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAccountType() {
        return userAccountType;
    }
}
