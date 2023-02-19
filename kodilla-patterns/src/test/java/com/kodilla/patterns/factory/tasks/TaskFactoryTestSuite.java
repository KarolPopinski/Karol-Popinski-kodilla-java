package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);
        //Then
        assertEquals("Deliver order 2334", drivingTask.getTaskName());
        System.out.println(drivingTask);
    }
    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);
        //Then
        assertEquals("Painting order 3189", paintingTask.getTaskName());
        System.out.println(paintingTask);
    }
    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);
        //Tehn
        assertEquals("Shopping order 0017", shoppingTask.getTaskName());
        System.out.println(shoppingTask);
    }
}
