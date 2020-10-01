package card;

import card.check.LuhnAlgorithm;
import db.AccountsData;

import java.util.concurrent.ThreadLocalRandom;


public class CreateCard {
    private static final Long MIN_RANGE_NUMBER_CARD = 1000000000L;
    private static final Long MAX_RANGE_NUMBER_CARD = 10000000000L;
    private static final short MIN_RANGE_PASSWORD_CARD = 1000;
    private static final short MAX_RANGE_PASSWORD_CARD = 10000;
    private static final String IIN = "400000";
    private final LuhnAlgorithm luhnAlgorithm;
    private final AccountsData accountsData;

    public CreateCard() {
        luhnAlgorithm = new LuhnAlgorithm();
        accountsData = new AccountsData();
    }

    public CardData getNewCard() {
        String cardNumber = generateCardNumber();
        String pass = String.valueOf(generatePassword());
        successfulCreationMsg(cardNumber, pass);

        CardData newCard = new CardData(cardNumber, pass);
        accountsData.addCardToDatabase(newCard);
        return newCard;
    }

    private String generateCardNumber() {
        long generatedNumber = ThreadLocalRandom
                .current()
                .nextLong(MIN_RANGE_NUMBER_CARD, MAX_RANGE_NUMBER_CARD);
        if (luhnAlgorithm.getCreditCardValidation(IIN + generatedNumber)) {
            return IIN + generatedNumber;
        } else {
            return generateCardNumber();
        }
    }

    private int generatePassword() {
        return ThreadLocalRandom
                .current()
                .nextInt(MIN_RANGE_PASSWORD_CARD, MAX_RANGE_PASSWORD_CARD);
    }

    private void successfulCreationMsg(String cardNumber, String pass) {
        System.out.printf("Your card has been created\nYour card number:\n" +
                "%s\nYour card PIN:\n%s\n", cardNumber, pass);
    }
}
