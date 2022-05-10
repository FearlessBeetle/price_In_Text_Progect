package service;

import api.services.ConsoleInputService;
import api.services.NumberFormatHandlerService;
import api.services.NumberParserService;

public class NumberParserImplementation implements NumberParserService {
    private String numberSequence;
    private NumberFormatHandlerService numberFormatHandler;
    private String[] beforeAndAfterDotNumbers;


    public NumberParserImplementation(ConsoleInputService consoleInputService,
                                      NumberFormatHandlerService numberFormatHandler) {
        this.numberFormatHandler = numberFormatHandler;
        try {
            this.numberSequence = this.numberFormatHandler.
                    formatNumberSequence(
                            consoleInputService.readString());
            if (numberSequence == null) {
            }
            this.beforeAndAfterDotNumbers = parseNumberSequence();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage() + ", try again please.");
        }

    }

    @Override
    public String[] parseNumberSequence() {
        try {
            if (numberSequence.equals(".")) {
                throw new RuntimeException("empty number space");
            } else if (numberSequence.contains(".")) {
                return numberSequence.split("\\.");
            } else {
                return new String[]{numberSequence};
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " : parsing error");
        }
        return new String[0];
    }

    @Override
    public short[] get99_0() {
        try {
            if (beforeAndAfterDotNumbers.length <= 1 || beforeAndAfterDotNumbers[1].isEmpty()) {
                return new short[0];
            } else {
                short[] tempResult = new short[beforeAndAfterDotNumbers[1].length()];
                if (beforeAndAfterDotNumbers[1].length() == 1) {
                    tempResult[0] = Byte.parseByte(beforeAndAfterDotNumbers[1]);
                    return tempResult;
                }
                String fracturePartTempString = beforeAndAfterDotNumbers[1];
                tempResult[0] = Short.parseShort(String.valueOf(fracturePartTempString.charAt(0)));
                tempResult[1] = Short.parseShort(String.valueOf(fracturePartTempString.charAt(1)));
                return tempResult;
            }
        } catch (RuntimeException e) {
            return new short[0];
        }
    }

    @Override
    public short[] get0_999() {
        try {
            int range = beforeAndAfterDotNumbers[0].length();
            if (beforeAndAfterDotNumbers[0].isEmpty()) {
                return new short[0];
            }
            short[] tempResult;
            if (beforeAndAfterDotNumbers.length < 3) {
                if (range < 4) {
                    switch (range) {
                        case (1) -> {
                            tempResult = new short[1];
                            parsingDigitRange(tempResult, 0, 0);
                            return tempResult;
                        }
                        case (2) -> {
                            tempResult = new short[2];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            return tempResult;
                        }
                        case (3) -> {
                            tempResult = new short[3];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            parsingDigitRange(tempResult, 2, 2);
                            return tempResult;
                        }
                    }
                } else {
                    tempResult = new short[3];
                    for (int i = 0, p = range - 3; i < 3; i++, p++) {
                        tempResult[i] = Short.parseShort(
                                String.valueOf(
                                        beforeAndAfterDotNumbers[0].charAt(p)));
                    }
                    return tempResult;
                }
            } else throw new RuntimeException("wrong parsing");
        } catch (
                RuntimeException e) {
            return new short[0];
        }
        return new short[0];
    }

    @Override
    public short[] get1000x_x999_999() {
        try {
            int range = beforeAndAfterDotNumbers[0].length();
            if (beforeAndAfterDotNumbers[0].isEmpty() || range < 4) {
                return new short[0];
            }
            short[] tempResult;
            if (beforeAndAfterDotNumbers.length < 3) {
                if (range < 7) {
                    switch (range) {
                        case (4) -> {
                            tempResult = new short[1];
                            parsingDigitRange(tempResult, 0, 0);
                            return tempResult;
                        }
                        case (5) -> {
                            tempResult = new short[2];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            return tempResult;
                        }
                        default -> {
                            tempResult = new short[3];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            parsingDigitRange(tempResult, 2, 2);
                            return tempResult;
                        }
                    }
                } else {
                    tempResult = new short[3];
                    for (int i = 0, p = range - 6; i < 3; i++, p++) {
                        tempResult[i] = Short.parseShort(
                                String.valueOf(
                                        beforeAndAfterDotNumbers[0].charAt(p)));
                    }
                    return tempResult;
                }
            }
        } catch (
                RuntimeException e) {
            return new short[0];
        }
        return new short[0];
    }

    @Override
    public short[] get1_000_000x_x999_999_999() {
        try {
            int range = beforeAndAfterDotNumbers[0].length();
            if (beforeAndAfterDotNumbers[0].isEmpty() || range < 7) {
                return new short[0];
            }
            short[] tempResult;
            if (beforeAndAfterDotNumbers.length < 3) {
                if (range < 10) {
                    switch (range) {
                        case (7) -> {
                            tempResult = new short[1];
                            parsingDigitRange(tempResult, 0, 0);
                            return tempResult;
                        }
                        case (8) -> {
                            tempResult = new short[2];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            return tempResult;
                        }
                        default -> {
                            tempResult = new short[3];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            parsingDigitRange(tempResult, 2, 2);
                            return tempResult;
                        }
                    }
                } else {
                    tempResult = new short[3];
                    for (int i = 0, p = range - 9; i < 3; i++, p++) {
                        tempResult[i] = Short.parseShort(
                                String.valueOf(
                                        beforeAndAfterDotNumbers[0].charAt(p)));
                    }
                    return tempResult;
                }
            }
        } catch (
                RuntimeException e) {
            return new short[0];
        }
        return new short[0];
    }

    @Override
    public short[] get1_000_000_000x_x999_999_999_999() {
        try {
            int range = beforeAndAfterDotNumbers[0].length();
            if (beforeAndAfterDotNumbers[0].isEmpty() || range < 10) {
                return new short[0];
            }
            short[] tempResult;
            if (beforeAndAfterDotNumbers.length < 3) {
                if (range < 13) {
                    switch (range) {
                        case (10) -> {
                            tempResult = new short[1];
                            parsingDigitRange(tempResult, 0, 0);
                            return tempResult;
                        }
                        case (11) -> {
                            tempResult = new short[2];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            return tempResult;
                        }
                        default -> {
                            tempResult = new short[3];
                            parsingDigitRange(tempResult, 0, 0);
                            parsingDigitRange(tempResult, 1, 1);
                            parsingDigitRange(tempResult, 2, 2);
                            return tempResult;
                        }
                    }
                } else {
                    tempResult = new short[1];
                    for (int i = 0, p = range - 12; i < 3; i++, p++) {
                        tempResult[i] = Short.parseShort(
                                String.valueOf(
                                        beforeAndAfterDotNumbers[0].charAt(p)));
                    }
                    return tempResult;
                }
            }
        } catch (
                RuntimeException e) {
            return new short[0];
        }
        return new short[0];
    }

    private void parsingDigitRange(short[] array, int index0_2, int position) {
        array[index0_2] =
                Short.parseShort(
                        String.valueOf(
                                beforeAndAfterDotNumbers[0].charAt(position)));
    }
}
