package api.services;

public interface TextForCurrencyService {
    String[][] getNUMS_TO_TEXT_1_10();

    String[] getNUMS_TO_TEXT_10_100();

    String[] getNUMS_TO_TEXT_100_1000();

    String[] getCATEGORY_OF_NUMBERS();

    String[] getCURRENCY_TEXT();
}
