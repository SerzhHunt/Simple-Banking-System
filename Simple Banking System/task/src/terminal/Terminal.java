package terminal;

import card.CardData;
import card.account.Account;
import card.account.AccountInfo;
import card.check.CheckCard;

import java.util.Scanner;

public class Terminal {
    private static final int MIN_RANGE_VALUE = 0;
    private static final int MAX_RANGE_VALUE = 2;
    private final Scanner scanner = new Scanner(System.in);

    public Terminal() {
    }

    public Terminal(AccountInfo accountInfo) {
    }

    public Terminal(CheckCard checkCard) {
    }

    public void getTerminal() {
        Account account = Account.getInstance();
        System.out.print("1. Create an account\n2. Log into account\n0. Exit\n");
        int number = checkNumber(Integer.parseInt(scanner.nextLine()));

        if (number == 1) {
            account.createCard();
            getTerminal();
        } else if (number == 2) {
            CardData card = account.logIntoAccount();
            account.getAccountInfo(card);
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
