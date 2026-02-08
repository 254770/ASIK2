package service;

import model.BankAccount;
import model.SavingsAccount;
import model.CheckingAccount;
import model.Customer;

public class AccountFactory {

    public static BankAccount createAccount(
            String type,
            String number,
            Customer owner,
            double balance
    ) {

        if (type.equalsIgnoreCase("SAVINGS")) {

            return new SavingsAccount(
                    number,
                    owner,
                    balance
            );
        }

        else if (type.equalsIgnoreCase("CHECKING")) {

            return new CheckingAccount(
                    number,
                    owner,
                    balance
            );
        }

        else {
            throw new IllegalArgumentException(
                    "Invalid account type"
            );
        }
    }
}
