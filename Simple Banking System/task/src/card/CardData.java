package card;

import java.math.BigInteger;

public class CardData {
    private final BigInteger cardNumber;
    private final short password;
    private long balance;

    public CardData(BigInteger cardNumber, short password) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.balance = 0;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CardData{" +
                "cardNumber=" + cardNumber +
                ", password=" + password +
                '}';
    }
}
