package model;

public class Transaction {

    private String id;
    private String accountNumber;
    private double amount;
    private String type;

    public Transaction(
            String id,
            String accountNumber,
            double amount,
            String type
    ) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
