public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer owner, double interestRate) {
        super(accountNumber, owner);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(
                    "TX" + System.nanoTime(),
                    accountNumber,
                    amount,
                    "WITHDRAW"
            ));
        }
    }
}
