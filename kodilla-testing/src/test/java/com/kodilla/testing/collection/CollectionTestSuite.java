package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Start Test");
    }
    @AfterEach
    public void after() {
        System.out.println("End Test");
    }
    @DisplayName("Class Test for Empty")
    @Test
    public void testOddNumbersExaminatorEmptyList() {

        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();

        //When
        ArrayList<Integer> listNumbers = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing" + listNumbers);

        //Then
        Assertions.assertEquals(emptyList, listNumbers);
    }
    @DisplayName("Class Test for odd numbers")
    @Test
    public void testOddNumbersExterminatorNormalList() {

        //Given
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 22, 85, 4, 8, 80, 100, 48, 2));
        ArrayList<Integer> oddList = new ArrayList<Integer>(Arrays.asList(22,4,8,80,100,48,2));

        //When
        ArrayList<Integer> listNumbers = OddNumbersExterminator.exterminate(list);
        System.out.println("Testing" + listNumbers);

        //Then
        Assertions.assertEquals(oddList, listNumbers);
    }
}
