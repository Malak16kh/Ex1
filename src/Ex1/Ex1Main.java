package Ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display menu options.
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
                System.out.println("Exiting...");
                break;
            }

            // Perform the operation based on user input.
            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    String num = scanner.nextLine();
                    System.out.println("Valid: " + Ex1.isNumber(num));
                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    num = scanner.nextLine();
                    System.out.println("Decimal Value: " + Ex1.number2Int(num));
                    break;
                case 3:
                    System.out.print("Enter a decimal number: ");
                    int decimal = scanner.nextInt();
                    System.out.print("Enter the base: ");
                    int base = scanner.nextInt();
                    System.out.println("Converted: " + Ex1.int2Number(decimal, base));
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    String n1 = scanner.nextLine();
                    System.out.print("Enter second number: ");
                    String n2 = scanner.nextLine();
                    System.out.println("Equal: " + Ex1.equals(n1, n2));
                    break;
                case 5:
                    System.out.print("Enter array size: ");
                    int size = scanner.nextInt();
                    scanner.nextLine();
                    String[] arr = new String[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        arr[i] = scanner.nextLine();
                    }
                    System.out.println("Max Index: " + Ex1.maxIndex(arr));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
