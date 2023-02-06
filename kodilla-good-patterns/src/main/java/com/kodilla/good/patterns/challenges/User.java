package com.kodilla.good.patterns.challenges;

public class User {

    private String name;
    private String surname;
    private String emailAdress;

    public User(String name, String surname, String emailAdress) {
        this.name = name;
        this.surname = surname;
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }
}
