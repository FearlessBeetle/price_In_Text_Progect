package api.services;

public interface PriceToTextService {
    String getFinalPriceConversion();

    void categoryConstruction(short[] array, short idForText, StringBuilder result);

    void numberConstruction(short n, short idForText, StringBuilder result);

    void dozensConstruction(short n, short d, StringBuilder result);

    void hundredsConstruction(short h, StringBuilder result);

    void assignCategory (short d, short n, short idForText, StringBuilder result);
}
