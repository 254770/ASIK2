public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, Customer owner, double overdraftLimit) {
        super(accountNumber, owner);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
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
