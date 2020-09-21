package terminal;

import card.CardData;
import card.CheckCard;
import card.CreateCard;

import java.util.Scanner;

public class Terminal {
    private final Scanner scanner = new Scanner(System.in);
    private final CheckCard checkCard;
    private final CreateCard createCard;

    public Terminal() {
        checkCard = new CheckCard();
        createCard = new CreateCard();
    }

    public void getTerminal() {
        System.out.print("1. Create an account\n2. Log into account\n0. Exit\n");
        int number = numberCheck(scanner.nextInt());
        if (number == 1) {
            createCard.createCard();
        } else if (number == 2) {
            CardData card = checkCard.logIntoAccount();
            checkAccount(card);
        } else {
            System.out.println("Bye!");
        }
    }

    private void checkAccount(CardData card) {
        System.out.print("1. Balance\n2. Log out\n0. Exit\n");
        int number = numberCheck(scanner.nextInt());
        if (number == 1) {
            System.out.printf("Balance:%d", card.getBalance());
        } else if (number == 2) {
            System.out.println("You have successfully logged out!");
            getTerminal();
        } else {
            System.out.println("Bye!");
        }
    }

    private int numberCheck(int number) {
        if (number >= 0 && number <= 2) {
            return number;
        }
        return 0;
    }
}
