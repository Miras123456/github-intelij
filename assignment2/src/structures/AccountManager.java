package structures;

import java.util.*;

public class AccountManager {
    private LinkedList<BankAccount> accounts = new LinkedList<>();

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
    }

    public BankAccount findAccount(String name) {
        for (BankAccount a : accounts) {
            if (a.username.equalsIgnoreCase(name)) return a;
        }
        return null;
    }

    public void showAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts");
            return;
        }

        for (BankAccount a : accounts) {
            a.display();
        }
    }

    public int getSize() {
        return accounts.size();
    }
}