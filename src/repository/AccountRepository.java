package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountRepository {

    private Connection conn;

    public AccountRepository(Connection conn) {
        this.conn = conn;
    }

    // ===== CRUD METHODS =====

    // READ → Console
    public void getAllAccounts() {
        try {
            String sql = "SELECT * FROM bank_account";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("account_number") + " | " +
                                rs.getDouble("balance") + " | " +
                                rs.getString("account_type")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateBalance(String accNumber, double balance) {
        try {
            String sql =
                    "UPDATE bank_account SET balance=? WHERE account_number=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, balance);
            ps.setString(2, accNumber);
            ps.executeUpdate();

            System.out.println("UPDATE OK");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAccount(String accNumber) {
        try {
            String sql =
                    "DELETE FROM bank_account WHERE account_number=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accNumber);
            ps.executeUpdate();

            System.out.println("DELETE OK");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== JSON METHOD =====

    public String getAllAccountsAsJson() {

        StringBuilder json = new StringBuilder();
        json.append("[");

        try {
            String sql = "SELECT * FROM bank_account";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            boolean first = true;

            while (rs.next()) {

                if (!first) json.append(",");

                json.append("{")
                        .append("\"accountNumber\":\"")
                        .append(rs.getString("account_number"))
                        .append("\",")
                        .append("\"balance\":")
                        .append(rs.getDouble("balance"))
                        .append(",")
                        .append("\"type\":\"")
                        .append(rs.getString("account_type"))
                        .append("\"")
                        .append("}");

                first = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        json.append("]");
        return json.toString();

    }
    public void createAccount(
            String accNumber,
            double balance,
            String type
    ) {

        try {

            String sql =
                    "INSERT INTO bank_account(account_number, balance, account_type) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, accNumber);
            ps.setDouble(2, balance);
            ps.setString(3, type);

            ps.executeUpdate();

            System.out.println("ACCOUNT CREATED");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
