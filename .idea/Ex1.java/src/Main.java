package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Check if a number is valid.");
            System.out.println("2. Convert a number to decimal.");
            System.out.println("3. Convert a decimal to another base.");
            System.out.println("4. Compare two numbers.");
            System.out.println("5. Find the index of the largest number in an array.");
            System.out.println("6. Quit.");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    String number = scanner.nextLine();
                    if (Ex1.isNumber(number)) {
                        System.out.println("The number is valid.");
                    } else {
                        System.out.println("The number is not valid.");
                    }
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    String num = scanner.nextLine();
                    int decimalValue = Ex1.number2Int(num);
                    if (decimalValue == -1) {
                        System.out.println("Invalid number format.");
                    } else {
                        System.out.println("Decimal value: " + decimalValue);
                    }
                    break;

                case 3:
                    System.out.print("Enter a decimal number: ");
                    int decimalNum = scanner.nextInt();
                    System.out.print("Enter the base (2-16): ");
                    int base = scanner.nextInt();
                    String converted = Ex1.int2Number(decimalNum, base);
                    System.out.println("Converted number: " + converted);
                    break;

                case 4:
                    System.out.print("Enter the first number: ");
                    String n1 = scanner.nextLine();
                    System.out.print("Enter the second number: ");
                    String n2 = scanner.nextLine();
                    if (Ex1.equals(n1, n2)) {
                        System.out.println("The two numbers are equal.");
                    } else {
                        System.out.println("The two numbers are not equal.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    scanner.nextLine();
                    String[] arr = new String[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        arr[i] = scanner.nextLine();
                    }
                    int index = Ex1.maxIndex(arr);
                    if (index != -1) {
                        System.out.println("Index of the largest value: " + index);
                        System.out.println("Largest value: " + arr[index]);
                    } else {
                        System.out.println("No valid numbers in the array.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
