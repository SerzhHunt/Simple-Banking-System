package card;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class CheckCard {
    Scanner scanner = new Scanner(System.in);
    private final CardData cardData;

    public CheckCard() {
        cardData = new CardData();
    }

    public CardData logIntoAccount() {
        return checkExistingCard();
    }

    private CardData checkExistingCard() {
        BigInteger cardNumber = scanner.nextBigInteger();
        List<CardData> cardBase = this.cardData.getCardBase();

        for (CardData card : cardBase) {
            if (card.getCardNumber().equals(cardNumber)) {
                return checkPassword(card);
            }
        }
        return null; // temporarily, I know it is not recommended to return null =)
    }

    private CardData checkPassword(CardData card) {
        short pass = scanner.nextShort();

        if (card.getPassword() == pass) {
            System.out.println("You have successfully logged in!");
            return card;
        } else {
            System.out.println("Wrong card number or PIN!");
            return checkExistingCard();
        }
    }
}
