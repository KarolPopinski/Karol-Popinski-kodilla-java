package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openFile() {
        logger = Logger.INSTANCE;
        logger.log("To jest test loga!!!");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String lastLog = logger.getLastLog();
        System.out.println("Last log: " + lastLog);
        //Then
        assertEquals("To jest test loga!!!", lastLog);
    }

}
