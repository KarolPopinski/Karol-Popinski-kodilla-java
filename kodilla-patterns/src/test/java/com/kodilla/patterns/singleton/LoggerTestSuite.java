package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testGetLastLog() {
        //Given
        logger = Logger.INSTANCE;
        logger.log("2028-5-28: 13:28:06 logged in system");
        //When
        String lastLog = logger.getLastLog();
        System.out.println("Last log: " + lastLog);
        //Then
        assertEquals("2028-5-28: 13:28:06 logged in system", lastLog);
    }

}
