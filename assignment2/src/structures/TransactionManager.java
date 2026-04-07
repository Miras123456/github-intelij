package structures;

import java.util.*;

public class TransactionManager {
    private Stack<String> history = new Stack<>();

    public void addTransaction(String t) {
        history.push(t);
    }

    public void showLast() {
        if (!history.isEmpty()) {
            System.out.println("Last: " + history.peek());
        } else {
            System.out.println("No transactions");
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Undo: " + history.pop());
        }
    }
}