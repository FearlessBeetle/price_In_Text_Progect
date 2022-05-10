package service;

import api.services.TextForCurrencyService;
import domain.TextOfRubPrice;
import org.junit.Assert;
import org.junit.Test;


public class TextOfRubPriceTest {

    @Test
    public void testGet1_10RusText() {
        TextForCurrencyService text = new TextOfRubPrice();
        String[][] expectedText = new String[][]{{"один "},{"одна "}};
        String[][] actualText = text.getNUMS_TO_TEXT_1_10();
        Assert.assertEquals("incorrect getting text",
                expectedText[0][0], actualText[0][0]);
        Assert.assertEquals("incorrect getting text",
                expectedText[1][0], actualText[1][1]);
    }

    @Test
    public void testGet10_100RusText() {
        TextForCurrencyService text = new TextOfRubPrice();
        String[] expectedText = new String[]{"десять ", "девяносто "};
        String[] actualText = text.getNUMS_TO_TEXT_10_100();
        Assert.assertEquals("incorrect getting text",
                expectedText[0], actualText[0]);
        Assert.assertEquals("incorrect getting text",
                expectedText[1], actualText[17]);
    }

    @Test
    public void testGet100_1000RusText() {
        TextForCurrencyService text = new TextOfRubPrice();
        String[] expectedText = new String[]{"сто ", "девятьсот "};
        String[] actualText = text.getNUMS_TO_TEXT_100_1000();
        Assert.assertEquals("incorrect getting text",
                expectedText[0], actualText[0]);
        Assert.assertEquals("incorrect getting text",
                expectedText[1], actualText[8]);
    }

    @Test
    public void testGetCorrectRusCategory() {
        TextForCurrencyService text = new TextOfRubPrice();
        String[] expectedText = new String[]{"тысяча ", "миллиардов "};
        String[] actualText = text.getCATEGORY_OF_NUMBERS();
        Assert.assertEquals("incorrect getting text",
                expectedText[0], actualText[0]);
        Assert.assertEquals("incorrect getting text",
                expectedText[1], actualText[8]);
    }

    @Test
    public void testGetCorrectRusCurrency() {
        TextForCurrencyService text = new TextOfRubPrice();
        String[] expectedText = new String[]{"копейка ", "рублей "};
        String[] actualText = text.getCURRENCY_TEXT();
        Assert.assertEquals("incorrect getting text",
                expectedText[0], actualText[0]);
        Assert.assertEquals("incorrect getting text",
                expectedText[1], actualText[5]);
    }
}
