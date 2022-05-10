package service;

import api.services.ConsoleOutputService;
import api.services.PriceToTextService;

public class PriceResultOutput {
    private final PriceToTextService finalPriceResultString;
    private final ConsoleOutputService outputResultService;

    public PriceResultOutput(PriceToTextService finalString, ConsoleOutputService outputResultService) {
        this.finalPriceResultString = finalString;
        this.outputResultService = outputResultService;
    }

    public void showPriceResult(){
        outputResultService.outputStr(finalPriceResultString.getFinalPriceConversion().trim());
    }
}
