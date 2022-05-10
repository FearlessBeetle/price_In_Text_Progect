package service;

import api.services.NumberFormatHandlerService;


public class NumberFormatHandlerImplementation implements NumberFormatHandlerService {
    @Override
    public String formatNumberSequence(String numberSequence) {
        if (numberSequence == null) {
            throw new IllegalArgumentException("price field is null ");
        }
        String firstResult = numberSequence.trim();
        if (numberSequence.isEmpty()) {
            throw new RuntimeException("price field is empty");
        }
        if (!firstResult.matches("[^.0-9]")) {
            firstResult = firstResult.replaceAll("[^.0-9]", "");
            if (firstResult.equals(".") || firstResult.isEmpty()) {
                throw new RuntimeException("not contains numbers");
            }
        }
        if (firstResult.contains(".")) {
            int position = firstResult.indexOf(".");
            if (firstResult.indexOf(".") == firstResult.lastIndexOf(".")) {
                String integerPart = firstResult.substring(0, position);
                String fractionPart;
                if (position == 0) {
                    fractionPart = firstResult.substring(1);
                    fractionPart = removeExtraNumbers(fractionPart);
                    fractionPart = removeExtraZero(fractionPart);
                    firstResult = "." + fractionPart;
                    return firstResult;
                }
                fractionPart = firstResult.substring(position + 1);
                if (fractionPart.length() > 2) {
                    fractionPart = firstResult.substring(position + 1, position + 3);
                }
                integerPart = removeExtraNumbers(integerPart);
                integerPart = removeExtraZero(integerPart);
                fractionPart = removeExtraZero(fractionPart);
                firstResult = integerPart + "." + fractionPart;
                return firstResult;
            } else {
                throw new RuntimeException("too many dots");
            }
        }
        firstResult = removeExtraNumbers(firstResult);
        firstResult = removeExtraZero(firstResult);
        return firstResult;
    }

    @Override
    public String removeExtraZero(String numberSequence) {
        int endPoint = numberSequence.length() - 1;
        String result = numberSequence;
        byte firstNumber = Byte.parseByte(String.valueOf(result.charAt(0)));
        if (firstNumber == 0 && result.length() != 1) {
            for (int i = 0; i < endPoint; i++) {
                if (Byte.parseByte(String.valueOf(result.charAt(0))) == 0) {
                    result =
                            result.
                                    replaceFirst("0", "");
                }
            }
            return result;
        }
        return result;
    }

    @Override
    public String removeExtraNumbers(String numberSequence) {
        int endPoint = numberSequence.length();
        String result = "";
        if (endPoint > 12) {
            int startPoint = endPoint - 12;
            result = numberSequence.substring(
                    startPoint,
                    endPoint);
            return result;
        }
        return numberSequence;
    }
}
