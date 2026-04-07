package structures;

import java.util.*;

public class BankSystem {

    AccountManager accManager = new AccountManager();
    TransactionManager transManager = new TransactionManager();
    BillQueueManager billManager = new BillQueueManager();
    AccountRequestManager reqManager = new AccountRequestManager();

    public Scanner sc = new Scanner(System.in);

    public void addAccount() {
        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Balance: ");
        double b = sc.nextDouble();

        BankAccount acc = new BankAccount(accManager.getSize()+1, name, b);
        accManager.addAccount(acc);
    }

    public void deposit() {
        System.out.print("Name: ");
        String name = sc.next();

        BankAccount acc = accManager.findAccount(name);

        if (acc != null) {
            System.out.print("Amount: ");
            double x = sc.nextDouble();

            acc.balance += x;
            transManager.addTransaction("Deposit " + x);
        }
    }

    public void withdraw() {
        System.out.print("Name: ");
        String name = sc.next();

        BankAccount acc = accManager.findAccount(name);

        if (acc != null) {
            System.out.print("Amount: ");
            double x = sc.nextDouble();

            if (acc.balance >= x) {
                acc.balance -= x;
                transManager.addTransaction("Withdraw " + x);
            }
        }
    }

    public void showAccounts() {
        accManager.showAccounts();
    }

    public void showLastTransaction() {
        transManager.showLast();
    }

    public void undo() {
        transManager.undo();
    }
}