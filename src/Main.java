import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        try {

            Bank bank = new Bank();

            Customer customer = new Customer(
                    "C001",
                    "Ivan",
                    "Petrov",
                    "ivan@mail.com",
                    "123456789",
                    "Moscow"
            );

            bank.addCustomer(customer);

            BankAccount savings = new SavingsAccount("A1001", customer, 0.03);
            BankAccount checking = new CheckingAccount("A2001", customer, 500);

            bank.addAccount(savings);
            bank.addAccount(checking);

            savings.deposit(1500);
            checking.deposit(500);
            checking.withdraw(800);

            System.out.println("=== BANK LOGIC RESULT ===");
            System.out.println(bank.sortByBalanceDescending());


            Connection conn = DBConnection.getConnection();


            String insert = "INSERT INTO bank_account " +
                    "(account_number, customer_id, balance, active, account_type) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, "ACC10");
            ps.setLong(2, 1);
            ps.setDouble(3, 1000);
            ps.setBoolean(4, true);
            ps.setString(5, "SAVINGS");
            ps.executeUpdate();
            System.out.println("INSERT OK");


            ResultSet rs = conn.createStatement()
                    .executeQuery("SELECT * FROM bank_account");

            System.out.println("=== DATABASE CONTENT ===");
            while (rs.next()) {
                System.out.println(
                        rs.getString("account_number") + " | " +
                                rs.getDouble("balance") + " | " +
                                rs.getString("account_type")
                );
            }


            String update = "UPDATE bank_account SET balance = ? WHERE account_number = ?";
            PreparedStatement ups = conn.prepareStatement(update);
            ups.setDouble(1, 2500);
            ups.setString(2, "ACC10");
            ups.executeUpdate();
            System.out.println("UPDATE OK");


            String delete = "DELETE FROM bank_account WHERE account_number = ?";
            PreparedStatement dps = conn.prepareStatement(delete);
            dps.setString(1, "ACC10");
            dps.executeUpdate();
            System.out.println("DELETE OK");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
