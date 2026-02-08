package model;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    protected String accountNumber;
    protected Customer owner;
    protected double balance;
    protected boolean active;
    protected List<Transaction> transactions;

    public BankAccount(
            String accountNumber,
            Customer owner
    ) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
        this.active = true;
        this.transactions = new ArrayList<>();
    }

    // ===== ABSTRACT =====
    public abstract void withdraw(double amount);

    // ===== DEPOSIT =====
    public void deposit(double amount) {

        balance += amount;

        transactions.add(
                new Transaction(
                        "TX" + System.nanoTime(),
                        accountNumber,
                        amount,
                        "DEPOSIT"
                )
        );
    }

    // ===== GETTERS =====

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public boolean isActive() {
        return active;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
