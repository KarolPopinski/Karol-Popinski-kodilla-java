package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        //When
        BigDecimal theCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(15), theCost);
    }
    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        //When
        String description = thePizza.getDescription();
        //Then
        assertEquals("Basic pizza: dough, tomato souce, cheese", description);
    }
    @Test
    public void testPepperoniExtraCheeseGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PepperoniToppingsDecorator(thePizza);
        thePizza = new ExtraCheeseToppingsDecorator(thePizza);
        System.out.println(thePizza.getCost());
        //When
        BigDecimal theCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(25), theCost);
    }
    @Test
    public void testPepperoniExtraCheeseGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PepperoniToppingsDecorator(thePizza);
        thePizza = new ExtraCheeseToppingsDecorator(thePizza);
        System.out.println(thePizza.getDescription());
        //When
        String description = thePizza.getDescription();
        //Then
        assertEquals("Basic pizza: dough, tomato souce, cheese " +
                "+ pepperoni + extra cheese", description);
    }
    @Test
    public void testMushroomOlivesOnionPepperoniExtraCheeseGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new MushroomToppingsDecorator(thePizza);
        thePizza = new OlivesToppingsDecorator(thePizza);
        thePizza = new OnionToppingsDecorator(thePizza);
        thePizza = new PepperoniToppingsDecorator(thePizza);
        thePizza = new ExtraCheeseToppingsDecorator(thePizza);
        System.out.println(thePizza.getCost());
        //When
        BigDecimal theCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(34), theCost);
    }
    @Test
    public void testMushroomOlivesOnionPepperoniExtraCheeseGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new MushroomToppingsDecorator(thePizza);
        thePizza = new OlivesToppingsDecorator(thePizza);
        thePizza = new OnionToppingsDecorator(thePizza);
        thePizza = new PepperoniToppingsDecorator(thePizza);
        thePizza = new ExtraCheeseToppingsDecorator(thePizza);
        System.out.println(thePizza.getDescription());
        //When
        String description = thePizza.getDescription();
        //Then
        assertEquals("Basic pizza: dough, tomato souce, cheese " +
                "+ mushroom + olives + onion + pepperoni" +
                " + extra cheese", description);
    }
}
