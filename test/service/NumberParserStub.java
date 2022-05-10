package service;

import api.services.ConsoleInputService;
import api.services.NumberFormatHandlerService;

public class NumberParserStub extends NumberParserImplementation {
    private String[] sequenceArray;

    public NumberParserStub(ConsoleInputService consoleInputService,
                            NumberFormatHandlerService numberFormatHandler) {
        super(consoleInputService, numberFormatHandler);
        this.sequenceArray = parseNumberSequence();
    }

    public String[] getSequenceArray() {
        return sequenceArray;
    }
}
