package service;

import api.services.ConsoleOutputService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleOutputImplementationTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String expectedOutput;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        expectedOutput = "Hello printStream!";
    }

    @Test
    public void testConsoleOutputString() {
        ConsoleOutputService outputImpl = new ConsoleOutputImplementation();
        outputImpl.outputStr(expectedOutput);
        String actual = out.toString();
        Assert.assertEquals("incorrect output string", "Hello printStream!\r\n", actual);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
}
