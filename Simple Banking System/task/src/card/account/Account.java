package card.account;

import card.CardData;
import card.CreateCard;
import card.check.CheckCard;

public class Account {
    private static Account account;
    private final CreateCard createCard = new CreateCard();
    private final CheckCard checkCard = new CheckCard();
    private final AccountInfo accountInfo = new AccountInfo();

    private Account() {
    }

    public CardData createCard() {
        return createCard.getNewCard();
    }

    public CardData logIntoAccount() {
        return checkCard.logIntoAccount();
    }

    public void getAccountInfo(CardData card) {
        if (card != null) {
            accountInfo.accountInfo(card);
        }
    }

    public static Account getInstance() {
        if (account == null) {
            account = new Account();
        }
        return account;
    }
}
