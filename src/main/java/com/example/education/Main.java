package com.example.education;

import static com.example.education.JdbcExample.createClient;
import static com.example.education.JdbcExample.deleteClient;
import static com.example.education.JdbcExample.getClientById;
import static com.example.education.JdbcExample.updateClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String DB_URL = "your_db_url";
    private static final String DB_USERNAME = "your_db_username";
    private static final String DB_PASSWORD = "your_db_password";
    public static void main(String[] args) {
        try {
            // Устанавливаем соединение с базой данных
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Создаем клиента
            createClient(connection, "John Doe", "New York");

            // Получаем клиента по id
            Client client = getClientById(connection, 1);
            System.out.println("Client: " + client);

            // Обновляем данные клиента
            updateClient(connection, 1, "John Smith", "Los Angeles");

            // Удаляем клиента
            deleteClient(connection, 1);

            // Закрываем соединение с базой данных
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}