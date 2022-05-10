package service;


import org.junit.Assert;
import org.junit.Test;



public class ApplicationRunnerTest {
    private ApplicationRunnerStub app = new ApplicationRunnerStub("111222333444.111");

    @Test
    public void testApplicationRunningWithValidArgumentValue() {
        String expected = "сто одиннадцать миллиардов двести двадцать два миллиона " +
                "триста тридцать три тысячи четыреста сорок четыре рубля одиннадцать копеек ";
        app.run();
        String actual = app.getResult();
        Assert.assertEquals("Wrong application result", expected, actual);
    }

    @Test
    public void testApplicationRunningWithInvalidArgumentDots() {
        app = new ApplicationRunnerStub(".......");
        String expected = "";
        app.run();
        String actual = app.getResult();
        Assert.assertEquals("Wrong application result", expected, actual);
    }

    @Test
    public void testApplicationRunningWithInvalidArgumentText() {
        app = new ApplicationRunnerStub("aaaaaaaaa");
        String expected = "";
        app.run();
        String actual = app.getResult();
        Assert.assertEquals("Wrong application result", expected, actual);
    }

    @Test
    public void testApplicationRunningWithInvalidArgumentEmpty() {
        app = new ApplicationRunnerStub("");
        String expected = "";
        app.run();
        String actual = app.getResult();
        Assert.assertEquals("Wrong application result", expected, actual);
    }

    @Test
    public void testApplicationRunningWithInvalidArgumentNull() {
        app = new ApplicationRunnerStub(null);
        String expected = "";
        app.run();
        String actual = app.getResult();
        Assert.assertEquals("Wrong application result", expected, actual);
    }
}