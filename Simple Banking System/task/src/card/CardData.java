package card;

public class CardData {
    private final String cardNumber;
    private final String password;
    private final int balance;

    public CardData(String cardNumber, String password) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.balance = 0;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }
}
