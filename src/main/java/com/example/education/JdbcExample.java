package com.example.education;

import com.example.education.domain.Client;
import java.sql.*;

public class JdbcExample {
    private static final String DB_URL = "your_db_url";
    private static final String DB_USERNAME = "your_db_username";
    private static final String DB_PASSWORD = "your_db_password";



    static void createClient(Connection connection, String fullName, String city) throws SQLException {
        String insertQuery = "INSERT INTO clients (full_name, city) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, fullName);
            statement.setString(2, city);
            statement.executeUpdate();
        }
    }

    static Client getClientById(Connection connection, int id) throws SQLException {
        String selectQuery = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int clientId = resultSet.getInt("id");
                    String fullName = resultSet.getString("full_name");
                    String city = resultSet.getString("city");
                    return new Client(clientId, fullName, city);
                }
            }
        }
        return null;
    }

    static void updateClient(Connection connection, int id, String fullName, String city) throws SQLException {
        String updateQuery = "UPDATE clients SET full_name = ?, city = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, fullName);
            statement.setString(2, city);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    static void deleteClient(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
