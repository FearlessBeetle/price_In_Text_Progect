package service;

import api.services.*;
import domain.TextOfRubPrice;

public class ApplicationRunnerStub {
    private ConsoleInputSpy consoleInputSpy;
    private ConsoleOutputService consoleOutput;
    private NumberFormatHandlerService formatHandler;
    private NumberParserService numberParserService;
    private TextForCurrencyService textForCurrency;
    private PriceToTextImplementation priceToText;
    private PriceResultOutput resultOutput;
    private String result;


    public ApplicationRunnerStub(String inputString) {
        consoleInputSpy = new ConsoleInputSpy(inputString);
        consoleOutput = new ConsoleOutputImplementation();
        formatHandler = new NumberFormatHandlerImplementation();
        numberParserService = new NumberParserImplementation(consoleInputSpy, formatHandler);
        textForCurrency = new TextOfRubPrice();
        priceToText = new PriceToTextImplementation(textForCurrency, numberParserService);
        resultOutput = new PriceResultOutput(priceToText, consoleOutput);
        result = priceToText.getFinalPriceConversion();
    }

    public void run() {
        this.resultOutput.showPriceResult();
    }

    public String getResult() {
        return result;
    }
}
