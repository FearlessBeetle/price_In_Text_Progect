package service;

import api.services.ConsoleInputService;

public class ConsoleInputSpy implements ConsoleInputService {
    private int counterOfInput = 0;
    private String numberToCheck;

    public ConsoleInputSpy(String numberToCheck) {
        this.numberToCheck = numberToCheck;
    }

    @Override
    public String readString() {
        counterOfInput++;
        return numberToCheck;
    }

    public int getCounterOfInput() {
        return counterOfInput;
    }
}
