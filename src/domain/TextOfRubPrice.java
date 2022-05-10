package domain;

import api.services.TextForCurrencyService;

public class TextOfRubPrice implements TextForCurrencyService {
    public final String[][] NUMS_TO_TEXT_1_10 = new String[][]{{"один ", "два ", "три ", "четыре ",
            "пять ", "шесть ", "семь ", "восемь ", "девять "},
            {"ноль ","одна ", "две "}};
    public final String[] NUMS_TO_TEXT_10_100 = new String[]{
            "десять ","одиннадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать ", "двадцать ",
            "тридцать ", "сорок ", "пятьдесят " , "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "};
    public final String[] NUMS_TO_TEXT_100_1000 = new String[]{
            "сто ", "двести ", "триста ", "четыреста ",
            "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ",
            "девятьсот ",};
    public final String[] TEXT_OF_CATEGORY = new String[]{
            "тысяча ", "тысячи ", "тысяч ",
            "миллион ", "миллиона ", "миллионов ",
            "миллиард ", "миллиарда ", "миллиардов "};
    public final String[] CURRENCY_TEXT = new String[] {
            "копейка ", "копейки ", "копеек ",
            "рубль ","рубля ","рублей "
    };

    @Override
    public String[][] getNUMS_TO_TEXT_1_10() {
        return NUMS_TO_TEXT_1_10;
    }

    @Override
    public String[] getNUMS_TO_TEXT_10_100() {
        return NUMS_TO_TEXT_10_100;
    }

    @Override
    public String[] getNUMS_TO_TEXT_100_1000() {
        return NUMS_TO_TEXT_100_1000;
    }

    @Override
    public String[] getCATEGORY_OF_NUMBERS() {
        return TEXT_OF_CATEGORY;
    }

    @Override
    public String[] getCURRENCY_TEXT() {
        return CURRENCY_TEXT;
    }
}
