package card;


import java.util.ArrayList;
import java.util.List;

public class CardData {
    private static final List<CardData> cardBase = new ArrayList<>();
    private String cardNumber;
    private short password;
    private long balance;

    public CardData() {

    }

    public CardData(String cardNumber, short password) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.balance = 0;
    }

    public List<CardData> getCardData() {
        return cardBase;
    }

    public void addCardToBase(CardData card) {
        cardBase.add(card);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public short getPassword() {
        return password;
    }

    public long getBalance() {
        return balance;
    }
}
