package card.account;

import card.CardData;
import terminal.Terminal;

import java.util.Scanner;

public class AccountInfo {
    private final Terminal terminal;
    private static final int MIN_RANGE_VALUE = 0;
    private static final int MAX_RANGE_VALUE = 2;
    private static final Scanner scanner = new Scanner(System.in);

    public AccountInfo() {
        terminal = new Terminal(this);
    }

    public void accountInfo(CardData card) {
        accountTerminal(card);
    }

    private void accountTerminal(CardData card) {
        System.out.println("1. Balance\n2. Log out\n0. Exit\n");
        int number = checkNumber(Integer.parseInt(scanner.nextLine()));

        if (number == 1) {
            System.out.printf("Balance:%d\n", card.getBalance());
            accountTerminal(card);
        } else if (number == 2) {
            System.out.println("You have successfully logged out!");
            terminal.getTerminal();
        } else if (number == 0) {
            System.out.println("Bye!");
        }
    }

    private int checkNumber(int number) {
        if (number >= MIN_RANGE_VALUE && number <= MAX_RANGE_VALUE) {
            return number;
        }
        return 0;
    }
}
