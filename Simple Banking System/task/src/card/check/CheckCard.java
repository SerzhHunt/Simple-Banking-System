package card.check;

import card.CardData;
import db.check.ExistingCard;

import java.util.Scanner;

public class CheckCard {
    private final ExistingCard existingCard;
    private static final Scanner scanner = new Scanner(System.in);

    public CheckCard() {
        existingCard = new ExistingCard();
    }

    public CardData logIntoAccount() {
        return checkExistingCard();
    }

    private CardData checkExistingCard() {
        System.out.println("Enter your card number:");
        String cardNumber = scanner.nextLine();
        return checkPassword(existingCard.checkExistingCard(cardNumber));
    }

    private CardData checkPassword(String cardNumber) {
        System.out.println("Enter your PIN:");
        String pin = scanner.nextLine();

        if (existingCard.checkExistingPin(cardNumber).equals(pin)) {
            System.out.println("You have successfully logged in!");
            return new CardData(cardNumber, pin);
        } else {
            System.out.println("Wrong card number or PIN!");
            return null;
        }
    }
}
