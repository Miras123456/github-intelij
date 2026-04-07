package structures;

public class BankAccount {
    int accountNumber;
    String username;
    double balance;

    public BankAccount(int a, String b, double c) {
        accountNumber = a;
        username = b;
        balance = c;
    }

    public void display() {
        System.out.println(accountNumber + ". " + username + " – Balance: " + balance);
    }
}