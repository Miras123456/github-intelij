public class Searcher {

    public int search(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (a[m] == target)
                return m;

            if (a[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }
}