package db.check;

import java.sql.*;

public class ExistingCard {

    private static final String URL_TO_DB = "jdbc:sqlite:C:/Users/rakov/git/Simple Banking System/accounts_data.db";

    public String checkExistingCard(String cardNumber) {
        return checkCard(cardNumber);
    }

    public String checkExistingPin(String cardNumber) {
        return checkPin(cardNumber);
    }

    private String checkCard(String cardNumber) {
        String SQL = "SELECT number FROM card " +
                "WHERE " + cardNumber + " = number;";

        try (Connection connection = this.connect()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(SQL)) {
                    while (resultSet.next()) {
                        return resultSet.getString("number");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String checkPin(String cardNumber) {
        String SQL = "SELECT pin FROM card " +
                "WHERE " + cardNumber + " = number;";

        try (Connection connection = this.connect()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(SQL)) {
                    while (resultSet.next()) {
                        return resultSet.getString("pin");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
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
