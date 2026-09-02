import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class Solution {

    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a < 2)
                return false;

            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0)
                    return false;
            }

            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            int original = a;
            int reverse = 0;

            while (a > 0) {
                reverse = reverse * 10 + a % 10;
                a /= 10;
            }

            return original == reverse;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation operation;

            if (choice == 1) {
                operation = isOdd();
                System.out.println(operation.check(number) ? "ODD" : "EVEN");
            } else if (choice == 2) {
                operation = isPrime();
                System.out.println(operation.check(number) ? "PRIME" : "COMPOSITE");
            } else {
                operation = isPalindrome();
                System.out.println(operation.check(number) ? "PALINDROME" : "NOT PALINDROME");
            }
        }

        sc.close();
    }
}
