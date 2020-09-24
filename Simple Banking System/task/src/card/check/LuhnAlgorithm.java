package card.check;

import java.util.Arrays;

public class LuhnAlgorithm {
    private static final String SEPARATOR = "";

    public Boolean getCreditCardValidation(String cardNumber) {
        int[] digitCardNumber = Arrays
                .stream(cardNumber.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .toArray();

        return checkLuhnAlgorithm(digitCardNumber);
    }

    private boolean checkLuhnAlgorithm(int[] digitCardNumber) {
        int result = 0;
        for (int i = 0; i < digitCardNumber.length; i++) {
            int digit = digitCardNumber[i];
            if (i % 2 == 0) {
                int doubleDigit = digit * 2 > 9 ? digit * 2 - 9 : digit * 2;
                result += doubleDigit;
                continue;
            }
            result += digit;
        }
        return result % 10 == 0;
    }
}
