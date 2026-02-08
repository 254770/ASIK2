import com.sun.net.httpserver.HttpServer;
import controller.AccountController;

import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) {

        try {

            HttpServer server =
                    HttpServer.create(
                            new InetSocketAddress(8080),
                            0
                    );

            server.createContext(
                    "/accounts",
                    new AccountController()
            );

            server.setExecutor(null);
            server.start();

            System.out.println(
                    "Server started at http://localhost:8080/accounts"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
