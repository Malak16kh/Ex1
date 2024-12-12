package Ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (true) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            // Stop the program if the user types "quit"
            if (num1.equalsIgnoreCase(quit)) {
                break;
            }

            // Check if num1 is in the correct format
            if (!Ex1.isNumber(num1)) {
                System.out.println("num1= " + num1 + " is number: false , value: -1");
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            }

            // Convert num1 to its decimal value
            int val1 = Ex1.number2Int(num1);
            System.out.println("num1= " + num1 + " is number: true , value: " + val1);

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();

            // Stop the program if the user types "quit"
            if (num2.equalsIgnoreCase(quit)) {
                break;
            }

            // Check if num2 is in the correct format
            if (!Ex1.isNumber(num2)) {
                System.out.println("num2= " + num2 + " is number: false , value: -1");
                System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue;
            }

            // Convert num2 to its decimal value
            int val2 = Ex1.number2Int(num2);
            System.out.println("num2= " + num2 + " is number: true , value: " + val2);

            // Ask the user for the base and check if it's valid
            System.out.print("Enter a base for output: (a number [2,16]): ");
            int base;
            try {
                base = sc.nextInt();
                if (base < 2 || base > 16) {
                    System.out.println("ERR: invalid base " + base);
                    continue;
                }
            } catch (Exception e) {
                System.out.println("ERR: Invalid input. Please enter an integer for the base.");
                sc.nextLine(); // Clear the invalid input
                continue;
            }

            // Calculate the sum and product of the two numbers and format the results
            String sum = Ex1.int2Number(val1 + val2, base) + "b" + base;
            String product = Ex1.int2Number(val1 * val2, base) + "b" + base;
            System.out.println(num1 + " + " + num2 + " = " + sum);
            System.out.println(num1 + " * " + num2 + " = " + product);

            // Find the largest number among the inputs and results
            String[] values = {num1, num2, sum, product};
            int maxIdx = Ex1.maxIndex(values);
            System.out.println("Max number over [" + String.join(",", values) + "] is: " + values[maxIdx]);
        }

        // End the program
        System.out.println("Quitting now...");
        sc.close();
    }
}
