public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer customer = new Customer(
                "C001",
                "qwerty",
                "zxc",
                "qwerty@mail.com",
                "123456789",
                "Astana"
        );

        bank.addCustomer(customer);

        BankAccount savings = new SavingsAccount("A1001", customer, 0.03);
        BankAccount checking = new CheckingAccount("A2001", customer, 500);

        bank.addAccount(savings);
        bank.addAccount(checking);

        savings.deposit(1500);
        checking.deposit(500);
        checking.withdraw(800);

        System.out.println(bank.sortByBalanceDescending());
    }
}
