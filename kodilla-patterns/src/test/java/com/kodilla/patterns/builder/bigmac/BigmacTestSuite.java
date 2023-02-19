package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Bun with sesame")
                .burgers(3)
                .sauce("barbeque")
                .ingredient("Onion")
                .ingredient("Bacon")
                .ingredient("Pickled cucumber")
                .ingredient("Cheddar cheese")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngedietns = bigmac.getIngredients().size();
        int howManyBurgersIn = bigmac.getBurgers();
        //Then
        assertEquals(4, howManyIngedietns);
        assertEquals(3, howManyBurgersIn);
    }
}
