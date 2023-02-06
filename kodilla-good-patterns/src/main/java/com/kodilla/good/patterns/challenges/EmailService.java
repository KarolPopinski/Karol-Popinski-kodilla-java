package com.kodilla.good.patterns.challenges;

public class EmailService implements InformationServie {
    @Override
    public void inform(User user) {

        System.out.println();
        System.out.println("Message with info send!");
        System.out.println("Letter content: ");
        System.out.println("Hello: " + user.getName() + " " + "|" + " e-mail adress: " + user.getEmailAdress());
        System.out.println("Thank you, we take care of your order. " +
                "We'll do everything we can to make it as short as possible!");
    }
}
