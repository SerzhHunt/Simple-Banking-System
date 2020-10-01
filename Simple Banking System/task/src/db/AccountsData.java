package db;

import card.CardData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountsData {
    private static final String URL_TO_DB = "jdbc:sqlite:C:/Users/rakov/git/Simple Banking System/accounts_data.db";

    public void addCardToDatabase(CardData newCard) {
        createNewCardToDatabase(
                newCard.getCardNumber(),
                newCard.getPassword(),
                newCard.getBalance());
    }

    private void createNewCardToDatabase(String number, String pin, int balance) {
        String sql = "INSERT INTO card (number,pin,balance) " +
                "VALUES (?,?,?);";
        try (Connection connection = this.connect()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, number);
                statement.setString(2, pin);
                statement.setInt(3, balance);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_TO_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
