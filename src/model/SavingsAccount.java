package model;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(
            String accountNumber,
            Customer owner,
            double balance
    ) {
        super(accountNumber, owner);
        this.balance = balance;
    }

    @Override
    public void withdraw(double amount) {

        if (balance >= amount) {
            balance -= amount;

            transactions.add(
                    new Transaction(
                            "TX" + System.nanoTime(),
                            accountNumber,
                            amount,
                            "WITHDRAW"
                    )
            );
        } else {
            System.out.println(
                    "Insufficient funds"
            );
        }
    }
}
