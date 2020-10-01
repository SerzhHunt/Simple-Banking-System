package db.create;


import java.sql.*;

public class CreateDB {
    private static final String URL_TO_DB = "jdbc:sqlite:C:/Users/rakov/git/Simple Banking System/";

    public void createNewDatabase(String fileName) {
        String url = URL_TO_DB + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable(String databaseName, String tableName) {
        String URL = URL_TO_DB + databaseName;
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n" +
                "id INTEGER PRIMARY KEY,\n" +
                "number TEXT UNIQUE NOT NULL,\n" +
                "pin TEXT NOT NULL,\n" +
                "balance INTEGER DEFAULT 0 NOT NULL\n" +
                ");";
        try (Connection connection = DriverManager.getConnection(URL)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
