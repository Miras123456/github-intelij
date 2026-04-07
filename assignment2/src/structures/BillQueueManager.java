package structures;

import java.util.*;

public class BillQueueManager {
    private Queue<String> bills = new LinkedList<>();

    public void addBill(String b) {
        bills.add(b);
    }

    public void processBill() {
        if (!bills.isEmpty()) {
            System.out.println("Processing: " + bills.poll());
        } else {
            System.out.println("No bills");
        }
    }
}