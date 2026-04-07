package structures;

import java.util.*;

public class AccountRequestManager {
    private Queue<BankAccount> requests = new LinkedList<>();

    public void addRequest(BankAccount acc) {
        requests.add(acc);
    }

    public BankAccount processRequest() {
        return requests.poll();
    }
}