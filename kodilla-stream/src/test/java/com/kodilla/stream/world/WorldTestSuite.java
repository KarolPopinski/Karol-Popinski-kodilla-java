package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test get People quantity")
class WorldTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test#" + testCounter);
    }
    @Test
void testGetPeopleQuantity() {
        //Given
        Continent continent1 = new Continent("North America");
        continent1.addCountry(new Country("United States", new BigDecimal("336997624")));
        continent1.addCountry(new Country("Mexico", new BigDecimal("126705138")));
        continent1.addCountry(new Country("Canada", new BigDecimal("38155012")));

        Continent continent2 = new Continent("Oceania");
        continent2.addCountry(new Country("Australia", new BigDecimal("25921089")));
        continent2.addCountry(new Country("New Zealand", new BigDecimal("5129727")));
        continent2.addCountry(new Country("Papua", new BigDecimal("3486432")));

        Continent continent3 = new Continent("Asia");
        continent3.addCountry(new Country("China", new BigDecimal("1425893465")));
        continent3.addCountry(new Country("India", new BigDecimal("1407563842")));
        continent3.addCountry(new Country("Pakistan", new BigDecimal("211103000")));

        World world = new World();
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);

        //When
        BigDecimal populationOfWorld = world.getPeopleQuantity();

        //Then
        BigDecimal expPopultaion = new BigDecimal("3580955329");
        assertEquals(expPopultaion, populationOfWorld);
    }
}