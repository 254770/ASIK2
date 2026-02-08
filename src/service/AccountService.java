package service;

import repository.AccountRepository;

public class AccountService {

    private AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public void showAllAccounts() {
        repo.getAllAccounts();
    }

    public void deposit(String accNumber, double amount) {
        System.out.println("Depositing money...");
        repo.updateBalance(accNumber, amount);
    }

    public void removeAccount(String accNumber) {
        System.out.println("Deleting account...");
        repo.deleteAccount(accNumber);
    }
}
