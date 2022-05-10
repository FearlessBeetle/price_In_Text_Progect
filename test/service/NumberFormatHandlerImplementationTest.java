package service;


import api.services.ConsoleInputService;
import api.services.NumberFormatHandlerService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NumberFormatHandlerImplementationTest {
    private final String numbersOutOfRange = "123456789111234";
    private final String numbersWithZero = "000000000001";

    @Test
    public void testRemovingExtraZero() {
        String expected = "1";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        String actual = formatHandler.removeExtraZero(numbersWithZero);
        Assert.assertEquals("invalid extra-zero removing operation", expected, actual);
    }

    @Test
    public void testRemovingExtraNumbers() {
        String expected = "456789111234";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        String actual = formatHandler.removeExtraNumbers(numbersOutOfRange);
        Assert.assertEquals("invalid extra-numbers removing operation", expected, actual);
    }

    @Test
    public void testFormattingSequence() {
        String numbers = "123456789";
        String numbersWithDot = "123456.12";
        String numbersOutOfRangeWithDot = "123456789111234.023123";
        String numbersWithZeroWithDot = "0.00000000";
        String wordsInNumbers = "   aaaaaa123.aaaa456aaaa   ";
        String onlyFracturePart = ".1";
        String[] preActualArray = new String[]{numbersWithZero, numbersOutOfRange, numbers, numbersWithDot,
                numbersOutOfRangeWithDot, numbersWithZeroWithDot,
                wordsInNumbers, onlyFracturePart};
        String[] expectedArray = new String[]{"1", "456789111234", "123456789", "123456.12",
                "456789111234.2", "0.0",
                "123.45", ".1"};
        NumberFormatHandlerImplementation handlerImplementation = new NumberFormatHandlerImplementation();
        for (int i = 0; i < preActualArray.length; i++) {
            String actual = handlerImplementation.formatNumberSequence(preActualArray[i]);
            String expected = expectedArray[i];
            Assert.assertEquals("invalid number sequence formatting", expected, actual);
        }
    }

    @Test
    public void testFormattingSequenceInnerMethods() {
        ConsoleInputService consoleInputSpy = new ConsoleInputSpy("111222333444.111");
        NumberFormatHandlerSpy2 formatHandle = new NumberFormatHandlerSpy2();
        formatHandle.formatNumberSequence(consoleInputSpy.readString());
        int expectedZeroRemoving = 2;
        int expectedNumberRemoving = 1;
        int actualZeroRemoving = formatHandle.getCounterRemoveZero();
        int actualNumberRemoving = formatHandle.getCounterRemoveNumber();
        Assert.assertEquals("invalid amount of inner methods",
                expectedZeroRemoving, actualZeroRemoving);
        Assert.assertEquals("invalid amount of inner methods",
                expectedNumberRemoving, actualNumberRemoving);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testFormattingExceptionExtraDots() throws RuntimeException {
        String tooManyDots = "1.2.3";
        String expectedTooManyDots = "too many dots";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(expectedTooManyDots);
        formatHandler.formatNumberSequence(tooManyDots);
        thrown = ExpectedException.none();
    }

    @Test
    public void testFormattingExceptionEmptyString() throws RuntimeException {
        String emptyString = "";
        String expectedEmptyField = "price field is empty";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(expectedEmptyField);
        formatHandler.formatNumberSequence(emptyString);
        thrown = ExpectedException.none();
    }

    @Test
    public void testFormattingExceptionOnlyDot() throws RuntimeException {
        String onlyDot = ".";
        String expectedNotContain = "not contains numbers";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(expectedNotContain);
        formatHandler.formatNumberSequence(onlyDot);
        thrown = ExpectedException.none();
    }

    @Test
    public void testFormattingExceptionOnlyWords() throws RuntimeException {
        String onlyWords = "aaaaaaaaaaaaaaaa";
        String expectedNotContain = "not contains numbers";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(expectedNotContain);
        formatHandler.formatNumberSequence(onlyWords);
        thrown = ExpectedException.none();
    }

    @Test
    public void testFormattingExceptionNullField() throws IllegalArgumentException {
        String expectedNullField = "price field is null ";
        NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(expectedNullField);
        formatHandler.formatNumberSequence(null);
        thrown = ExpectedException.none();
    }
}