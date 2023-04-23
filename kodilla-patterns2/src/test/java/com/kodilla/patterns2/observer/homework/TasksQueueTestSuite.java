package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksQueueTestSuite {

    @Test
    public void testTasksQueue() {
        //Given
        TasksQueue student1 = new Student("Jan Testowy");
        TasksQueue student2 = new Student("Anna Testowa");
        TasksQueue student3 = new Student("Adam Testowy");
        TasksQueue student4 = new Student("Alicja Testowa");

        Mentor mentor1 = new Mentor("Mentor T1");
        Mentor mentor2 = new Mentor("Mentor T2");
        Mentor mentor3 = new Mentor("Mentor T3");

        student1.registerObserver(mentor1);
        student2.registerObserver(mentor2);
        student3.registerObserver(mentor3);
        student4.registerObserver(mentor1);
        //When
        student1.addTask("Task 1");
        student1.addTask("Task 2");
        student2.addTask("Task 1");
        student2.addTask("Task 2");
        student2.addTask("Task 3");
        student3.addTask("Task 1");
        student3.addTask("Task 2");
        student3.addTask("Task 3");
        student3.addTask("Task 4");
        student4.addTask("Task 1");
        //Given
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(3, mentor2.getUpdateCount());
        assertEquals(4, mentor3.getUpdateCount());
    }
}
