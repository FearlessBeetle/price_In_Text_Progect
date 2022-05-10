package service;

import api.services.ConsoleInputService;

import java.util.Scanner;

public class ConsoleInputImplementation implements ConsoleInputService {
    private Scanner in;

    public ConsoleInputImplementation() {
        System.out.println("Пожалуйста укажите цену менее 1 триллиона рублей и до 2 чисел после запятой." +
                "\nЛишние цифры будут отброшены.");
        in = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return in.nextLine();
    }
}
