package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("TDD: Shape Collector Test")
class ShapeCollectorTestSuite {

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

    @Nested
    @DisplayName("Tests for Add/Show")
    class TestAddShow {
        @Test
        void testAddFigure() {

            Circle circle = new Circle(50);
            Triangle triangle = new Triangle(10, 30);
            Square square = new Square(20);

            //Given
            ShapeCollector testList = new ShapeCollector(new ArrayList<Shape>(Arrays.asList(circle, triangle, square)));

            //When
            testList.addFigure(new Square(20));
            int actualListsSize = testList.getShapesList().size();

            //Then
            Assertions.assertEquals(4, actualListsSize);
        }

        @Test
        void testShowFigures() {

            Circle circle = new Circle(50);
            Triangle triangle = new Triangle(10, 30);
            Square square = new Square(20);

            //Given
            ArrayList<Shape> testList = new ArrayList<Shape>(Arrays.asList(circle, triangle, square));

            //When
            ShapeCollector shCollection = new ShapeCollector(testList);

            //Then
            Assertions.assertEquals(testList, shCollection.showFigures());
        }
    }
    @Nested
    @DisplayName("Test for Remove/Get")
    class TestRemGet {
        @Test
        void testRemoveFigure() {

            Circle circle = new Circle(50);
            Triangle triangle = new Triangle(10, 30);
            Square square = new Square(20);

            //Given
            ShapeCollector testList = new ShapeCollector(new ArrayList<Shape>(Arrays.asList(circle, triangle, square)));

            //When
            testList.removeFigure(square);
            int actualListSize = testList.getShapesList().size();

            //Then
            Assertions.assertEquals(2, actualListSize);
        }

        @Test
        void testGetFigure() {

            Circle circle = new Circle(50);
            Triangle triangle = new Triangle(10, 30);
            Square square = new Square(20);

            ShapeCollector testList = new ShapeCollector(new ArrayList<Shape>(Arrays.asList(circle, triangle, square)));

            //When
            Shape shape1 = testList.getFigure(1);
            Shape shape2 = testList.getFigure(-40);
            Shape shape3 = testList.getFigure(100);

            //Then
            Assertions.assertEquals(triangle, shape1);
            Assertions.assertEquals(null, shape2);
            Assertions.assertEquals(null, shape3);
        }

    }
}