package com.kodilla.good.patterns.food2door;

public class EmailService implements InformationService {

    @Override
    public void inform(String supplier) {

        System.out.println("Message with info send!");
        System.out.println("Letter content: ");
        System.out.println("Hello: " + supplier);
        System.out.println("We have order for your products."+" Please start packing them");
        System.out.println();
    }
}
