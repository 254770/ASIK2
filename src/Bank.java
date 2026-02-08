package service;

import model.BankAccount;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Bank {

    private List<Customer> customers = new ArrayList<>();
    private List<BankAccount> accounts = new ArrayList<>();

    // ===== ADD =====

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // ===== FIND =====

    public BankAccount findAccountByNumber(String number) {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    // ===== ACTIVE =====

    public List<BankAccount> getActiveAccounts() {
        return accounts.stream()
                .filter(a -> a.isActive())
                .collect(Collectors.toList());
    }

    // ===== BALANCE FILTER =====

    public List<BankAccount> getAccountsWithBalanceAbove(
            double amount
    ) {
        return accounts.stream()
                .filter(a -> a.getBalance() > amount)
                .collect(Collectors.toList());
    }

    // ===== SORT =====

    public List<BankAccount> sortByBalanceDescending() {
        return accounts.stream()
                .sorted(
                        Comparator.comparingDouble(
                                BankAccount::getBalance
                        ).reversed()
                )
                .collect(Collectors.toList());
    }
}
