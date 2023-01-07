package com.kodilla.stream.array;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Array Tests")
class ArrayOperationsTestSuite {

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
    void testGetAverage() {
        //Given
        int numbers[] = {3, 5, 1, 17, 16, 32, 50, 99, 4, 7, 2, 6, 81, 46, 77, 39, 69, 19, 22, 8};

        //Given
        double resultAverage = ArrayOperations.getAverage(numbers);
        System.out.println(resultAverage);

        //Then
        assertEquals(30.15, resultAverage);
    }
}
