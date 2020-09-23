package card;

import java.util.concurrent.ThreadLocalRandom;


public class CreateCard {
    private static final Long MIN_RANGE_NUMBER_CARD = 1000000000L;
    private static final Long MAX_RANGE_NUMBER_CARD = 10000000000L;
    private static final short MIN_RANGE_PASSWORD_CARD = 1000;
    private static final short MAX_RANGE_PASSWORD_CARD = 10000;
    private static final String IIN = "400000";
    private final CardData cardData;

    public CreateCard() {
        cardData = new CardData();
    }

    public CardData getNewCard() {
        String cardNumber = generateCardNumber();
        short pass = generatePassword();
        successfulCreationMsg(cardNumber, pass);

        CardData newCard = new CardData(cardNumber, pass);
        cardData.addCardToBase(newCard);
        return newCard;
    }

    private String generateCardNumber() {
        long generated = ThreadLocalRandom
                .current()
                .nextLong(MIN_RANGE_NUMBER_CARD, MAX_RANGE_NUMBER_CARD);
        return IIN + generated;
    }

    private short generatePassword() {

        return (short) ThreadLocalRandom
                .current()
                .nextInt(MIN_RANGE_PASSWORD_CARD, MAX_RANGE_PASSWORD_CARD);
    }

    private void successfulCreationMsg(String cardNumber, short pass) {
        System.out.printf("Your card has been created\nYour card number:\n" +
                "%s\nYour card PIN:\n%04d\n", cardNumber, pass);
    }
}
