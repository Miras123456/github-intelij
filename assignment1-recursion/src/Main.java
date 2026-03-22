import java.util.*;

public class Main {

    //Task 1
    static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    //Task 2
    static int sum(int[] a, int i) {
        if (i == 0) return a[0];
        return a[i] + sum(a, i - 1);
    }

    static double average(int[] a) {
        return (double) sum(a, a.length - 1) / a.length;
    }

    //Task 3
    static boolean isPrime(int n, int i) {
        if (n <= 1) return false;
        if (i == n) return true;
        if (n % i == 0) return false;
        return isPrime(n, i + 1);
    }

    //Task 4
    static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    //Task 5
    static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //Task 6
    static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    //Task 7
    static void reverse(int[] a, int i) {
        if (i < 0) return;
        System.out.print(a[i] + " ");
        reverse(a, i - 1);
    }

    //Task 8
    static boolean onlyDigits(String s, int i) {
        if (i == s.length()) return true;

        char c = s.charAt(i);
        if (c < '0' || c > '9') return false;

        return onlyDigits(s, i + 1);
    }

    //Task 9
    static int length(String s) {
        if (s.equals("")) return 0;
        return 1 + length(s.substring(1));
    }

    //ask 10
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Task 1
        System.out.println("Task 1:");
        printDigits(5481);

        //Task 2
        System.out.println("\nTask 2:");
        int[] a = {3, 2, 4, 1};
        System.out.println(average(a));

        //Task 3
        System.out.println("\nTask 3:");
        System.out.println(isPrime(7, 2) ? "Prime" : "Composite");

        //Task 4
        System.out.println("\nTask 4:");
        System.out.println(factorial(5));

        //Task 5
        System.out.println("\nTask 5:");
        System.out.println(fib(5));

        //Task 6
        System.out.println("\nTask 6:");
        System.out.println(power(2, 10));

        //Task 7
        System.out.println("\nTask 7:");
        int[] b = {1, 4, 6, 2};
        reverse(b, b.length - 1);

        //Task 8
        System.out.println("\nTask 8:");
        System.out.println(onlyDigits("123456", 0) ? "Yes" : "No");

        //Task 9
        System.out.println("\nTask 9:");
        System.out.println(length("hello"));

        //Task 10
        System.out.println("\nTask 10:");
        System.out.println(gcd(32, 48));
    }
}