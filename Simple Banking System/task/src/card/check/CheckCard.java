package card.check;

import card.CardData;

import java.util.List;
import java.util.Scanner;

public class CheckCard {
    private final CardData cardData;
    private static final Scanner scanner = new Scanner(System.in);

    public CheckCard() {
        cardData = new CardData();
    }

    public CardData logIntoAccount() {
        return checkExistingCard();
    }

    private CardData checkExistingCard() {
        System.out.println("Enter your card number:");
        String cardNumber = scanner.nextLine();
        List<CardData> cardBase = cardData.getCardData();

        for (CardData card : cardBase) {
            if (card.getCardNumber().equals(cardNumber)) {
                return checkPassword(card);
            }
        }
        return checkPassword(cardData); //strange solution, but works.
    }

    private CardData checkPassword(CardData card) {
        System.out.println("Enter your PIN:");
        short pass = (short) Integer.parseInt(scanner.nextLine());

        if (card.getPassword() == pass) {
            System.out.println("You have successfully logged in!");
            return card;
        } else {
            System.out.println("Wrong card number or PIN!");
            return null;
        }
    }
}
