package service;

import api.services.*;
import domain.TextOfRubPrice;

public class ApplicationRunner {
    protected ConsoleInputService consoleInput = new ConsoleInputImplementation();
    protected ConsoleOutputService consoleOutput = new ConsoleOutputImplementation();
    protected NumberFormatHandlerService formatHandler = new NumberFormatHandlerImplementation();
    protected NumberParserService numberParserService = new NumberParserImplementation(consoleInput,formatHandler);
    protected TextForCurrencyService textForCurrency = new TextOfRubPrice();
    protected PriceToTextImplementation priceToText = new PriceToTextImplementation(textForCurrency, numberParserService);
    protected PriceResultOutput resultOutput = new PriceResultOutput(priceToText, consoleOutput);

    public void run() {
        resultOutput.showPriceResult();
    }
}
