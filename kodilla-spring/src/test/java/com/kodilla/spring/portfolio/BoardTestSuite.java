package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("Task1 is TO DO!");
        board.getInProgressList().getTasks().add("Task1 is in progress#*#");
        board.getDoneList().getTasks().add("Task1 id done!");

        String firstTaskToDo = board.getToDoList().getTasks().get(0);
        String firstTaskInProgress = board.getInProgressList().getTasks().get(0);
        String firsTaskDone = board.getDoneList().getTasks().get(0);

        //Then
        assertEquals(firstTaskToDo, "Task1 is TO DO!");
        assertEquals(firstTaskInProgress, "Task1 is in progress#*#");
        assertEquals(firsTaskDone, "Task1 id done!");

        System.out.println(board.getDoneList().getTasks());
        System.out.println(board.getInProgressList().getTasks());
        System.out.println(board.getToDoList().getTasks());
    }
}
