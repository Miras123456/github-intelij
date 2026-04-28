public class Experiment {

    private Sorter s = new Sorter();
    private Searcher sh = new Searcher();

    public long measureSortTime(int[] a, String type) {
        int[] copy = a.clone();

        long start = System.nanoTime();

        if (type.equals("basic")) {
            s.basicSort(copy);
        } else {
            s.advancedSort(copy);
        }

        long end = System.nanoTime();

        return end - start;
    }

    public long measureSearchTime(int[] a, int target) {
        long start = System.nanoTime();

        sh.search(a, target);

        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("\n=== SIZE: " + size + " ===");

            int[] random = s.generateRandomArray(size);
            int[] sorted = s.generateSortedArray(size);

            long t1 = measureSortTime(random, "basic");
            long t2 = measureSortTime(random, "advanced");

            s.advancedSort(random);
            int target = random[size / 2];

            long t3 = measureSearchTime(random, target);

            System.out.println("Bubble Sort (random): " + t1);
            System.out.println("Merge Sort (random): " + t2);
            System.out.println("Binary Search: " + t3);

            long t4 = measureSortTime(sorted, "basic");
            long t5 = measureSortTime(sorted, "advanced");

            System.out.println("Bubble Sort (sorted): " + t4);
            System.out.println("Merge Sort (sorted): " + t5);
        }
    }
}