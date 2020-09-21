package card;

import java.math.BigInteger;
import java.util.Random;


public class Create {
    private final Random random = new Random();

    public CardData createCard() {
        BigInteger cardNumber = generateCardNumber();
        short pass = generatePassword();

        successfulCreationMsg(cardNumber,pass);
        return new CardData(cardNumber, pass);
    }

    private BigInteger generateCardNumber() {
        long generated = random.ints(999999999, 1000000000).sum();
        return BigInteger.valueOf(400000).and(BigInteger.valueOf(generated));
    }

    private short generatePassword() {
        return (short) random.ints(9999, 1000).sum();
    }

    private void successfulCreationMsg(BigInteger cardNumber, short pass) {
        System.out.printf("Your card has been created\nYour card number:\n" +
                "%d\nYour card PIN:\n%d", cardNumber, pass);
    }
}
