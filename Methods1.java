/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MethodsLab;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Methods {

    // --- Task 1: Greeting Method ---

    // Changed to private as it's only used internally by this class
    private static void greetUser() {
        System.out.println("Hello, welcome to the Math Program!");
    }

    // --- Task 2: Arithmetic Methods ---

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    // IMPORTANT: Added robust check for division by zero
    private static double divide(double a, double b) {
        if (b == 0) {
            System.err.println("Error: Division by zero is not allowed.");
            return Double.NaN; // mobalik og 'dili number' aron mag-indicated na failed siya.
        }
        return a / b;
    }

    // --- Task 3: Factorial Method ---

    // IMPORTANT: Added check for negative numbers, as factorial is undefined for them
    private static long factorial(int n) {
        if (n < 0) {
            System.err.println("Error: Factorial is undefined for negative numbers.");
            return -1; // Sentinel value to indicate error
        }
        long fact = 1;
        // Optimization: ang loop kay magsugod sa 2 since i-multiply by 1 since  walay mausab, 
        for (int i = 2; i <= n; i++) {
            // Added check to mitigate potential overflow, although 'long' is used
            if (fact > Long.MAX_VALUE / i) {
                System.err.println("Warning: Factorial result exceeded the capacity of a 'long'.");
                return Long.MAX_VALUE;
            }
            fact *= i;
        }
        return fact;
    }

    // --- Task 4: Array Summation Method ---

    private static int sumArray(int[] arr) {
        int sum = 0;
        // Enhanced for loop is concise and clear
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    // --- Task 5: Prime Checker Method ---

    // Correctly optimized to check only up to the square root of n
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        // Optimization: Handle even numbers first, then check only odd divisors
        if (n % 2 == 0 && n > 2) return false;

        // Ang loop kay mag check sa odd numbers gikan 3 hangtud sa sqaure root 
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // --- Utility Method for Input Handling ---
    
    // Helper method para safe ma read the system ang integer ug ang handle non-integer nga imong i-input 
    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = sc.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter an integer.");
                sc.next(); // Clears the invalid token from the scanner buffer
            }
        }
    }

    // --- Main Program ---

    public static void main(String[] args) {

        // mag -gamit ug try-with-resources para ma ensure nga ang scanner kay safely closed    
        try (Scanner sc = new Scanner(System.in)) {
            
            // Task 1
            greetUser();

            // Task 2: Calculator
            System.out.println("\n--- Basic Calculator ---");
            int num1 = getIntInput(sc, "Enter first number: ");
            int num2 = getIntInput(sc, "Enter second number: ");
            
            // Note: We cast back to double for division to use the double method signature
            System.out.println("Addition: " + add(num1, num2));
            System.out.println("Subtraction: " + subtract(num1, num2));
            System.out.println("Multiplication: " + multiply(num1, num2));
            System.out.println("Division: " + divide((double)num1, (double)num2));

            // Task 3: Factorial
            System.out.println("\n--- Factorial Calculation ---");
            int f = getIntInput(sc, "Enter a number for factorial (N): ");
            System.out.println("Factorial: " + factorial(f));

            // Task 4: Array Sum
            int[] numbers = {10, 20, 15, 18, 12};
            System.out.println("\n--- Array Summation ---");
            System.out.println("Array elements: " + Arrays.toString(numbers));
            System.out.println("Sum of array elements: " + sumArray(numbers));

            // Task 5: Prime Number Checker
            System.out.println("\n--- Prime Checker ---");
            int p = getIntInput(sc, "Enter a number to check for primality (P): ");
            
            System.out.print(p);
            if (isPrime(p)) {
                System.out.println(" is prime.");
            } else {
                System.out.println(" is not prime.");
            }
            
        } catch (Exception e) {
            // Generic catch block for any unexpected issues
            System.err.println("\nAn unexpected error occurred: " + e.getMessage());
        }}

    private static class util {

        public util() {
        }

        private static class Arrays {

            public Arrays() {
            }
        }
    }
}
    