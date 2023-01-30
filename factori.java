package inter;

import java.util.Scanner;

public class Factori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 3-digit number: ");
        int A = sc.nextInt();
        if (A >= 0 && A <= 999) {
            boolean result = isPalindromic(A);
            if (result) {
                System.out.println(A + " is a palindrome.");
                int combinations = factorial(3);
                System.out.println("Number of combinations: " + combinations);
                System.out.println("Suggested passwords:");
                for (int i = 0; i < combinations; i++) {
                    System.out.println(rotate(A, i));
                }
            } else {
                System.out.println(A + " is not a palindrome.");
            }
        } else {
            System.out.println("Error: number exceeded 3 digits.");
        }
    }

    public static boolean isPalindromic(int A) {
        int reverse = 0;
        int original = A;
        while (A > 0) {
            int lastDigit = A % 10;
            reverse = reverse * 10 + lastDigit;
            A /= 10;
        }
        return original == reverse;
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int rotate(int A, int rotation) {
        int units = A % 10;
        int tens = (A / 10) % 10;
        int hundreds = A / 100;
        int rotated = units * 100 + tens * 10 + hundreds;
        return rotated + rotation * 100;
