package service;

import api.services.ConsoleInputService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;


public class ConsoleInputImplementationTest {
    private ByteArrayInputStream in = new ByteArrayInputStream("11112222".getBytes());
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String expectedNotification = "Пожалуйста укажите цену менее 1 триллиона рублей и"
            + " до 2 чисел после запятой." +
            "\nЛишние цифры будут отброшены.\r\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        System.setIn(in);
    }

    @Test
    public void testConsoleReadString() {
        ConsoleInputService inputImpl = new ConsoleInputImplementation();
        String actual = inputImpl.readString();
        Assert.assertEquals("incorrect input reading", "11112222", actual);
    }

    @Test
    public void testConsoleUserNotification() {
        ConsoleInputService inputImpl = new ConsoleInputImplementation();
        inputImpl.readString();
        String actual = out.toString();
        Assert.assertEquals("incorrect user notification", expectedNotification, actual);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
        try {
            System.in.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
