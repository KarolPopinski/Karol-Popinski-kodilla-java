package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "TO DO")
    public TaskList getToDoList() {
        return new TaskList();
    }
    @Bean(name = "IN PROGRESS")
    public TaskList getInProgressList() {
        return new TaskList();

    }
    @Bean(name = "DONE")
    public TaskList getDoneList() {
        return new TaskList();
    }
    @Bean
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }
}
