package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import repository.AccountRepository;
import config.DBConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

public class AccountController implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "";

        try {

            // Подключение к базе
            Connection conn = DBConnection.getConnection();

            // Repository
            AccountRepository repo = new AccountRepository(conn);

            // ===== GET → получить все аккаунты =====
            if (exchange.getRequestMethod().equals("GET")) {

                response = repo.getAllAccountsAsJson();
            }

            // ===== POST → создать аккаунт =====
            else if (exchange.getRequestMethod().equals("POST")) {

                // Пока тестово создаём фиксированный аккаунт
                repo.createAccount("ACC99", 5000, "SAVINGS");

                response = "Account created!";
            }

            // ===== Если другой метод =====
            else {
                response = "Method not supported";
            }

        } catch (Exception e) {
            response = "Error: " + e.getMessage();
        }

        // Отправка ответа
        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
