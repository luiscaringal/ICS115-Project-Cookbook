package com.ics115_project.cookbook;

public class User {
    String userName;
    String email;
    String name;
    String accountType;
    String phoneNumber;

    public User(){

    }

    public User(String userName, String email, String name, String accountType, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.accountType = accountType;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
