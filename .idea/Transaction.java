import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private String type;
    private LocalDateTime timestamp;

    public Transaction(String transactionId, String accountNumber,
                       double amount, String type) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + transactionId + '\'' +
                ", account='" + accountNumber + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", date=" + timestamp +
                '}';
    }
}
