package service;

public class NumberFormatHandlerSpy2 extends NumberFormatHandlerImplementation {
    private int counterRemoveZero = 0;
    private int counterRemoveNumber = 0;

    @Override
    public String formatNumberSequence(String numberSequence) {
        return super.formatNumberSequence(numberSequence);
    }

    @Override
    public String removeExtraZero(String numberSequence) {
        counterRemoveZero++;
        return (numberSequence);
    }

    @Override
    public String removeExtraNumbers(String numberSequence) {
        counterRemoveNumber++;
        return numberSequence;
    }

    public int getCounterRemoveZero() {
        return counterRemoveZero;
    }

    public int getCounterRemoveNumber() {
        return counterRemoveNumber;
    }
}
