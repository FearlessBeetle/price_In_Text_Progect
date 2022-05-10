package service;

import api.services.ConsoleOutputService;

import java.io.PrintStream;

public class ConsoleOutputImplementation implements ConsoleOutputService {
    private final PrintStream out;

    public ConsoleOutputImplementation (){
        out = System.out;
    }

    @Override
    public void outputStr(String s) {
        out.println(s);
    }
}
