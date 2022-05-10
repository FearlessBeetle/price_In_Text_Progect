package service;

import api.services.PriceToTextService;
import api.services.TextForCurrencyService;
import domain.TextOfRubPrice;
import org.junit.Assert;
import org.junit.Test;

public class PriceToTextImplementationTest {
    private final TextForCurrencyService rusText = new TextOfRubPrice();
    private final ConsoleInputSpy inputSpy = new ConsoleInputSpy("111222333444.111");
    private final NumberFormatHandlerSpy handlerSpy = new NumberFormatHandlerSpy();
    private final NumberParserStub parserStub = new NumberParserStub(inputSpy, handlerSpy);
    private final PriceToTextService priceToText = new PriceToTextImplementation(rusText, parserStub);
    private StringBuilder result = new StringBuilder(20);

    @Test
    public void testNumberConstruction() {
        String expected = "четыре ";
        priceToText.numberConstruction((short) 4, (short) 3, result);
        String actual = result.toString();
        Assert.assertEquals("incorrect conversion number to text", expected, actual);
        expected = "девять ";
        result = new StringBuilder(20);
        priceToText.numberConstruction((short) 9, (short) 3, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion number to text", expected, actual);
    }

    @Test
    public void testDozensConstruction() {
        String expected = "сорок ";
        priceToText.dozensConstruction((short) 4, (short) 3, result);
        String actual = result.toString();
        Assert.assertEquals("incorrect conversion dozens to text", expected, actual);
        expected = "девяносто ";
        result = new StringBuilder(20);
        priceToText.dozensConstruction((short) 9, (short) 9, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion dozens to text", expected, actual);
        expected = "двенадцать ";
        result = new StringBuilder(20);
        priceToText.dozensConstruction((short) 1, (short) 2, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion dozens to text", expected, actual);
    }

    @Test
    public void testHundredsConstruction() {
        result = new StringBuilder(20);
        String expected = "четыреста ";
        priceToText.hundredsConstruction((short) 4, result);
        String actual = result.toString();
        Assert.assertEquals("incorrect conversion hundreds to text", expected, actual);

        expected = "девятьсот ";
        result = new StringBuilder(20);
        priceToText.hundredsConstruction((short) 9, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion dozens to text", expected, actual);
    }

    @Test
    public void testAssignCategory() {
        result = new StringBuilder(20);
        String expected = "копеек ";
        priceToText.assignCategory((short) 1, (short) 1, (short) 4, result);
        String actual = result.toString();
        Assert.assertEquals("incorrect naming for numbers", expected, actual);

        result = new StringBuilder(20);
        expected = "рубля ";
        priceToText.assignCategory((short) 4, (short) 4, (short) 3, result);
        actual = result.toString();
        Assert.assertEquals("incorrect naming for numbers", expected, actual);

        expected = "тысячи ";
        result = new StringBuilder(20);
        priceToText.assignCategory((short) 3, (short) 3, (short) 2, result);
        actual = result.toString();
        Assert.assertEquals("incorrect naming for numbers", expected, actual);

        result = new StringBuilder(20);
        expected = "миллиона ";
        priceToText.assignCategory((short) 2, (short) 2, (short) 1, result);
        actual = result.toString();
        Assert.assertEquals("incorrect naming for numbers", expected, actual);

        result = new StringBuilder(20);
        expected = "миллиардов ";
        priceToText.assignCategory((short) 1, (short) 1, (short) 0, result);
        actual = result.toString();
        Assert.assertEquals("incorrect naming for numbers", expected, actual);
    }

    @Test
    public void testCategoryConstruction() {
        result = new StringBuilder(50);
        short[] expectedArray = new short[]{1, 1};
        String expected = "одиннадцать копеек ";
        priceToText.categoryConstruction(expectedArray, (short) 4, result);
        String actual = result.toString();
        Assert.assertEquals("incorrect conversion of numbers, dozens, hundreds to text",
                expected, actual);

        result = new StringBuilder(50);
        expectedArray = new short[]{4, 4, 4};
        expected = "четыреста сорок четыре рубля ";
        priceToText.categoryConstruction(expectedArray, (short) 3, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion of numbers, dozens, hundreds to text",
                expected, actual);

        result = new StringBuilder(50);
        expectedArray = new short[]{3, 3, 3};
        expected = "триста тридцать три тысячи ";
        priceToText.categoryConstruction(expectedArray, (short) 2, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion of numbers, dozens, hundreds to text",
                expected, actual);

        result = new StringBuilder(50);
        expectedArray = new short[]{2, 2, 2};
        expected = "двести двадцать два миллиона ";
        priceToText.categoryConstruction(expectedArray, (short) 1, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion of numbers, dozens, hundreds to text",
                expected, actual);

        result = new StringBuilder(50);
        expectedArray = new short[]{1, 1, 1};
        expected = "сто одиннадцать миллиардов ";
        priceToText.categoryConstruction(expectedArray, (short) 0, result);
        actual = result.toString();
        Assert.assertEquals("incorrect conversion of numbers, dozens, hundreds to text",
                expected, actual);
    }

    @Test
    public void testFinalPriceConversion() {
        result = new StringBuilder(100);
        String expected = "сто одиннадцать миллиардов двести двадцать два миллиона " +
                "триста тридцать три тысячи четыреста сорок четыре рубля одиннадцать копеек ";
        String actual = priceToText.getFinalPriceConversion();
        Assert.assertEquals("incorrect conversion price to text", expected, actual);
    }
}
