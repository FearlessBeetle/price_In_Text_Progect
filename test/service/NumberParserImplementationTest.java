package service;

import api.services.ConsoleInputService;
import api.services.NumberFormatHandlerService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NumberParserImplementationTest {
    @Test
    public void testNumberParserConstructor() {
        ConsoleInputSpy consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerSpy formatHandlerSpy = new NumberFormatHandlerSpy();
        new NumberParserImplementation(consoleInputSpy, formatHandlerSpy);
        int expectedInput = 1;
        int expectedFormatting = 1;
        int actualInput = consoleInputSpy.getCounterOfInput();
        int actualFormatting = formatHandlerSpy.getCounterFormatSequence();
        Assert.assertEquals("invalid input counter while creating Parser",
                expectedInput, actualInput);
        Assert.assertEquals("invalid formatting counter while creating Parser",
                expectedFormatting, actualFormatting);
    }

    @Test
    public void testParsingSequence() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerService formatHandle = new NumberFormatHandlerImplementation();
        NumberParserStub numberParser = new NumberParserStub(consoleInputSpy, formatHandle);
        String[] expectedParsedArray = new String[] {"111222333444", "11"};
        String[] actualParsedArray = numberParser.getSequenceArray();
        Assert.assertEquals("invalid parsing number sequences",
                expectedParsedArray, actualParsedArray);
    }

    @Test
    public void testGettingFracturedPart() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerService formatHandle = new NumberFormatHandlerImplementation();
        NumberParserImplementation numberParser = new NumberParserImplementation(
                consoleInputSpy, formatHandle);
        short[] expectedFracturePart = new short[] {1,1};
        short[] actualFracturePart = numberParser.get99_0();
        Assert.assertTrue("invalid parsing number sequences",
                Arrays.equals(expectedFracturePart, actualFracturePart));
    }

    @Test
    public void testGettingHundreds() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerService formatHandle = new NumberFormatHandlerImplementation();
        NumberParserImplementation numberParser = new NumberParserImplementation(
                consoleInputSpy, formatHandle);
        short[] expectedFracturePart = new short[] {4,4,4};
        short[] actualFracturePart = numberParser.get0_999();
        Assert.assertTrue("invalid parsing number sequences",
                Arrays.equals(expectedFracturePart, actualFracturePart));
    }

    @Test
    public void testGettingThousands() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerService formatHandle = new NumberFormatHandlerImplementation();
        NumberParserImplementation numberParser = new NumberParserImplementation(
                consoleInputSpy, formatHandle);
        short[] expectedFracturePart = new short[] {3,3,3};
        short[] actualFracturePart = numberParser.get1000x_x999_999();
        Assert.assertTrue("invalid parsing number sequences",
                Arrays.equals(expectedFracturePart, actualFracturePart));
    }

    @Test
    public void testGettingMillions() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerService formatHandle = new NumberFormatHandlerImplementation();
        NumberParserImplementation numberParser = new NumberParserImplementation(
                consoleInputSpy, formatHandle);
        short[] expectedFracturePart = new short[] {2,2,2};
        short[] actualFracturePart = numberParser.get1_000_000x_x999_999_999();
        Assert.assertTrue("invalid parsing number sequences",
                Arrays.equals(expectedFracturePart, actualFracturePart));
    }

    @Test
    public void testGettingBillions() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerService formatHandle = new NumberFormatHandlerImplementation();
        NumberParserImplementation numberParser = new NumberParserImplementation(
                consoleInputSpy, formatHandle);
        short[] expectedFracturePart = new short[] {1,1,1};
        short[] actualFracturePart = numberParser.get1_000_000_000x_x999_999_999_999();
        Assert.assertTrue("invalid parsing number sequences",
                Arrays.equals(expectedFracturePart, actualFracturePart));
    }
}
