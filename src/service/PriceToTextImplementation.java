package service;


import api.services.NumberParserService;
import api.services.PriceToTextService;
import api.services.TextForCurrencyService;


public class PriceToTextImplementation implements PriceToTextService {
    private TextForCurrencyService textForCurrentCurrency;
    private NumberParserService numberSequence;
    private String[][] textFor1_10;
    private String[] textFor10_100;
    private String[] textFor100_1000;
    private String[] textForCategory;
    private String[] textForCurrency;
    private short[] fractionPart;
    private short[] hundreds;
    private short[] hundredsOfThousands;
    private short[] millions;
    private short[] billions;

    public PriceToTextImplementation(TextForCurrencyService textForCurrencyService,
                                     NumberParserService numberParserService) {
        this.textForCurrentCurrency = textForCurrencyService;
        this.numberSequence = numberParserService;

        textFor1_10 = textForCurrentCurrency.getNUMS_TO_TEXT_1_10();
        textFor10_100 = textForCurrentCurrency.getNUMS_TO_TEXT_10_100();
        textFor100_1000 = textForCurrentCurrency.getNUMS_TO_TEXT_100_1000();
        textForCategory = textForCurrentCurrency.getCATEGORY_OF_NUMBERS();
        textForCurrency = textForCurrentCurrency.getCURRENCY_TEXT();

        fractionPart = numberSequence.get99_0();
        hundreds = numberSequence.get0_999();
        hundredsOfThousands = numberSequence.get1000x_x999_999();
        millions = numberSequence.get1_000_000x_x999_999_999();
        billions = numberSequence.get1_000_000_000x_x999_999_999_999();
    }

    @Override
    public String getFinalPriceConversion() {
        StringBuilder resultString = new StringBuilder();
        try {
            if (billions.length != 0) {
                categoryConstruction(billions, (short) 0, resultString);
            }
            if (millions.length != 0) {
                categoryConstruction(millions, (short) 1, resultString);
            }
            if (hundredsOfThousands.length != 0) {
                categoryConstruction(hundredsOfThousands, (short) 2, resultString);
            }
            if (hundreds.length == 1) {
                if (hundreds[0] == 0) {
                    resultString.append(textFor1_10[1][0]);
                    resultString.append(textForCurrency[5]);
                } else {
                    categoryConstruction(hundreds, (short) 3, resultString);
                }
            } else if (hundreds.length != 0) {
                categoryConstruction(hundreds, (short) 3, resultString);
            }
            if (fractionPart.length == 1) {
                if (fractionPart[0] == 0) {
                    resultString.append(textFor1_10[1][0]);
                    resultString.append(textForCurrency[2]);
                } else {
                    categoryConstruction(fractionPart, (short) 4, resultString);
                }
            } else if (fractionPart.length != 0) {
                categoryConstruction(fractionPart, (short) 4, resultString);
            }
            return resultString.toString();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " : finalPriceConstruction Error");
        }
        return resultString.toString();
    }

    @Override
    public void categoryConstruction(short[] array, short idForText, StringBuilder resultString) {
        try {
            short tempHundreds = 0;
            short tempDozens = 0;
            short tempNumbers;
            if (array.length == 3) {
                tempHundreds = array[0];
                tempDozens = array[1];
                tempNumbers = array[2];
            } else if (array.length == 2) {
                tempDozens = array[0];
                tempNumbers = array[1];
            } else {
                tempNumbers = array[0];
            }
            if ((idForText != 3 && idForText != 4) &&
                    (tempDozens == 0 && tempHundreds == 0 && tempNumbers == 0)) {
                return;
            }
            if (idForText != 4) {
                hundredsConstruction(tempHundreds, resultString);
                dozensConstruction(tempDozens, tempNumbers, resultString);
                if (tempDozens != 1) {
                    numberConstruction(tempNumbers, idForText, resultString);
                }
            } else {
                if (array.length == 1) {
                    numberConstruction(tempNumbers, idForText, resultString);
                } else {
                    tempDozens = array[0];
                    tempNumbers = array[1];
                    dozensConstruction(tempDozens, tempNumbers, resultString);
                    if (tempDozens != 1) {
                        numberConstruction(tempNumbers, idForText, resultString);
                    }
                }
            }

            assignCategory(tempDozens, tempNumbers, idForText, resultString);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " : categoryConstruction Error");
        }

    }

    @Override
    public void numberConstruction(short n, short idForText, StringBuilder resultString) {
        try {
            switch (n) {
                case (1) -> {
                    if (idForText == 2 || idForText == 4) {
                        resultString.append(textFor1_10[1][1]);
                    } else {
                        resultString.append(textFor1_10[0][0]);
                    }
                }
                case (2) -> {
                    if (idForText == 2 || idForText == 4) {
                        resultString.append(textFor1_10[1][2]);
                    } else {
                        resultString.append(textFor1_10[0][1]);
                    }
                }
                case (3) -> resultString.append(textFor1_10[0][2]);
                case (4) -> resultString.append(textFor1_10[0][3]);
                case (5) -> resultString.append(textFor1_10[0][4]);
                case (6) -> resultString.append(textFor1_10[0][5]);
                case (7) -> resultString.append(textFor1_10[0][6]);
                case (8) -> resultString.append(textFor1_10[0][7]);
                case (9) -> resultString.append(textFor1_10[0][8]);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " : numberConstruction Error");
        }
    }

    @Override
    public void dozensConstruction(short d, short n, StringBuilder resultString) {
        try {
            if (d == 1) {
                switch (n) {
                    case (0) -> resultString.append(textFor10_100[0]);
                    case (1) -> resultString.append(textFor10_100[1]);
                    case (2) -> resultString.append(textFor10_100[2]);
                    case (3) -> resultString.append(textFor10_100[3]);
                    case (4) -> resultString.append(textFor10_100[4]);
                    case (5) -> resultString.append(textFor10_100[5]);
                    case (6) -> resultString.append(textFor10_100[6]);
                    case (7) -> resultString.append(textFor10_100[7]);
                    case (8) -> resultString.append(textFor10_100[8]);
                    case (9) -> resultString.append(textFor10_100[9]);
                }
            } else {
                switch (d) {
                    case (2) -> resultString.append(textFor10_100[10]);
                    case (3) -> resultString.append(textFor10_100[11]);
                    case (4) -> resultString.append(textFor10_100[12]);
                    case (5) -> resultString.append(textFor10_100[13]);
                    case (6) -> resultString.append(textFor10_100[14]);
                    case (7) -> resultString.append(textFor10_100[15]);
                    case (8) -> resultString.append(textFor10_100[16]);
                    case (9) -> resultString.append(textFor10_100[17]);
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " : dozenConstruction Error");
        }
    }

    @Override
    public void hundredsConstruction(short h, StringBuilder resultString) {
        try {
            switch (h) {
                case (1) -> resultString.append(textFor100_1000[0]);
                case (2) -> resultString.append(textFor100_1000[1]);
                case (3) -> resultString.append(textFor100_1000[2]);
                case (4) -> resultString.append(textFor100_1000[3]);
                case (5) -> resultString.append(textFor100_1000[4]);
                case (6) -> resultString.append(textFor100_1000[5]);
                case (7) -> resultString.append(textFor100_1000[6]);
                case (8) -> resultString.append(textFor100_1000[7]);
                case (9) -> resultString.append(textFor100_1000[8]);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " : hundredsConstruction : Error");
        }
    }

    @Override
    public void assignCategory(short d, short n, short idForText, StringBuilder result) {
        if (d == 1) {
            if (idForText == 0) {
                result.append(textForCategory[8]);
            } else if (idForText == 1) {
                result.append(textForCategory[5]);
            } else if (idForText == 2) {
                result.append(textForCategory[2]);
            } else if (idForText == 3) {
                result.append(textForCurrency[5]);
            } else if (idForText == 4) {
                result.append(textForCurrency[2]);
            }
        } else {
            switch (n) {
                case (1) -> {
                    if (idForText == 0) {
                        result.append(textForCategory[6]);
                    } else if (idForText == 1) {
                        result.append(textForCategory[3]);
                    } else if (idForText == 2) {
                        result.append(textForCategory[0]);
                    } else if (idForText == 3) {
                        result.append(textForCurrency[3]);
                    } else if (idForText == 4) {
                        result.append(textForCurrency[0]);
                    }
                }
                case (2), (3), (4) -> {
                    if (idForText == 0) {
                        result.append(textForCategory[7]);
                    } else if (idForText == 1) {
                        result.append(textForCategory[4]);
                    } else if (idForText == 2) {
                        result.append(textForCategory[1]);
                    } else if (idForText == 3) {
                        result.append(textForCurrency[4]);
                    } else if (idForText == 4) {
                        result.append(textForCurrency[1]);
                    }
                }
                case (0), (5), (6), (7), (8), (9) -> {
                    if (idForText == 0) {
                        result.append(textForCategory[8]);
                    } else if (idForText == 1) {
                        result.append(textForCategory[5]);
                    } else if (idForText == 2) {
                        result.append(textForCategory[2]);
                    } else if (idForText == 3) {
                        result.append(textForCurrency[5]);
                    } else if (idForText == 4) {
                        result.append(textForCurrency[2]);
                    }
                }
            }
        }
    }
}
