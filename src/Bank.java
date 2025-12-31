import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    private List<Customer> customers = new ArrayList<>();
    private List<BankAccount> accounts = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccountByNumber(String number) {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    public List<BankAccount> getActiveAccounts() {
        return accounts.stream()
                .filter(a -> a.active)
                .collect(Collectors.toList());
    }

    public List<BankAccount> getAccountsWithBalanceAbove(double amount) {
        return accounts.stream()
                .filter(a -> a.getBalance() > amount)
                .collect(Collectors.toList());
    }

    public List<BankAccount> sortByBalanceDescending() {
        return accounts.stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance).reversed())
                .collect(Collectors.toList());
    }
}
