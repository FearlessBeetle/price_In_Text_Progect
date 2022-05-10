package service;

import api.services.NumberFormatHandlerService;

public class NumberFormatHandlerSpy implements NumberFormatHandlerService {
    private int counterFormatSequence = 0;

    @Override
    public String formatNumberSequence(String numberSequence) {
        counterFormatSequence++;
        return numberSequence;
    }

    @Override
    public String removeExtraZero(String numberSequence) {
        return null;
    }

    @Override
    public String removeExtraNumbers(String numberSequence) {
        return null;
    }

    public int getCounterFormatSequence() {
        return counterFormatSequence;
    }
}
