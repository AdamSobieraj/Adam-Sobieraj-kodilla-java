package com.kodilla.patterns.singleton;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeClass
    public static void openSettingsFile() {
        Logger.getInstance();
    }

    @Test
    public void testSingleInstance() {
        // Given
        // When
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        // Then
        assertSame(log1, log2);
    }

    @Test
    public void testGetLastLog() {
        // Given
        String logContent = "code line";
        logger.log(logContent);

        // When
        String lastLog = logger.getLastLog();

        // Then
        assertEquals(logContent, lastLog);
    }


}
