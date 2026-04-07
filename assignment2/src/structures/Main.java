package structures;

public class Main {
    public static void main(String[] args) {

        BankSystem bank = new BankSystem();

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Accounts");
            System.out.println("5. Show Last Transaction");
            System.out.println("6. Undo Transaction");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int c = bank.sc.nextInt();

            if (c == 1) bank.addAccount();
            else if (c == 2) bank.deposit();
            else if (c == 3) bank.withdraw();
            else if (c == 4) bank.showAccounts();
            else if (c == 5) bank.showLastTransaction();
            else if (c == 6) bank.undo();
            else break;
        }
    }
}