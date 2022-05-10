package service;

import api.services.ConsoleOutputService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PriceResultOutputTest {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testShowingPriceResult() {
        ConsoleOutputService outputImpl = new ConsoleOutputImplementation();
        PriceToTextStub pttStub = new PriceToTextStub();
        PriceResultOutput priceResultOutput = new PriceResultOutput(pttStub,outputImpl);
        priceResultOutput.showPriceResult();
        String actual = out.toString();
        Assert.assertEquals("incorrect showing price result to user", "Hello printStream!\r\n", actual);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);

    }
}
