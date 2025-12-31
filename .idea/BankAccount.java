import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BankAccount {
    protected String accountNumber;
    protected Customer owner;
    protected double balance;
    protected boolean active;
    protected List<Transaction> transactions;

    public BankAccount(String accountNumber, Customer owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
        this.active = true;
        this.transactions = new ArrayList<>();
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(
                "TX" + System.nanoTime(),
                accountNumber,
                amount,
                "DEPOSIT"
        ));
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void closeAccount() {
        active = false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + accountNumber + '\'' +
                ", owner=" + owner.getFullName() +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
