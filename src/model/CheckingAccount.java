package model;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(
            String accountNumber,
            Customer owner,
            double balance
    ) {
        super(accountNumber, owner);
        this.balance = balance;
    }

    @Override
    public void withdraw(double amount) {

        balance -= amount;

        transactions.add(
                new Transaction(
                        "TX" + System.nanoTime(),
                        accountNumber,
                        amount,
                        "WITHDRAW"
                )
        );
    }
}
