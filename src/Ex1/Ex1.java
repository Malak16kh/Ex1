package Ex1;

public class Ex1 {

    /**
     * Checks if a given string is in the correct format of a number with a base.
     * A valid format is like "101b2" or "A1b16".
     * Returns false for invalid formats like "123b", "b2", or null.
     */
    public static boolean isNumber(String num) {
        if (num == null || !num.contains("b")) {
            return false;
        }
        int indexOfB = num.indexOf('b');
        if (indexOfB == 0 || indexOfB == num.length() - 1) {
            return false;
        }

        String numberPart = num.substring(0, indexOfB);
        String basePart = num.substring(indexOfB + 1);

        try {
            int base = Integer.parseInt(basePart);
            if (base < 2 || base > 16) {
                return false; // Base should be between 2 and 16
            }
            for (char digit : numberPart.toCharArray()) {
                int value = Character.isDigit(digit) ? digit - '0' : Character.toUpperCase(digit) - 'A' + 10;
                if (value >= base) {
                    return false; // Digit is invalid for the given base
                }
            }
        } catch (NumberFormatException e) {
            return false; // Base is not a number
        }
        return true;
    }

    /**
     * Converts a valid number string (like "101b2") into its decimal value.
     * Returns -1 if the input is invalid or cannot be converted.
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1; // Return -1 for invalid numbers
        }

        int indexOfB = num.indexOf('b');
        String numberPart = num.substring(0, indexOfB); // Extract the part before 'b'
        int base = Integer.parseInt(num.substring(indexOfB + 1)); // Extract the base after 'b'

        try {
            return Integer.parseInt(numberPart, base); // Convert the number to decimal
        } catch (NumberFormatException e) {
            return -1; // Error in conversion
        }
    }

    /**
     * Checks if two numbers in string format are equal in value.
     * For example, "1011b2" and "11b10" both represent the number 11, so they are equal.
     * Returns false if either input is invalid.
     */
    public static boolean equals(String n1, String n2) {
        if (!isNumber(n1) || !isNumber(n2)) {
            return false; // Return false if either number is invalid
        }
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);
        return num1 == num2; // Check if their decimal values are the same
    }

    /**
     * Converts a decimal number into a string representation with the specified base.
     * For example, 11 in base 2 would be "1011b2".
     * Returns an empty string if the base is invalid (not between 2 and 16).
     */
    public static String int2Number(int num, int base) {
        if (base < 2 || base > 16) {
            return ""; // Return an empty string for invalid bases
        }

        StringBuilder result = new StringBuilder();
        int current = num;
        do {
            int remainder = current % base;
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
            result.insert(0, digit); // Add the digit at the start of the result
            current /= base;
        } while (current > 0);

        return result + "b" + base; // Add the base at the end
    }

    /**
     * Finds the index of the largest number in an array of number strings.
     * Skips invalid numbers and returns -1 if no valid numbers are found.
     * For example, in {"101b2", "A1b16", "15b10"}, "A1b16" (value 161) is the largest.
     */
    public static int maxIndex(String[] values) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < values.length; i++) {
            int value = number2Int(values[i]); // Convert each number to decimal
            if (value == -1) {
                continue; // Skip invalid numbers
            }
            if (value > maxValue) {
                maxValue = value; // Update the max value
                maxIndex = i; // Update the index of the max value
            }
        }

        return maxIndex; // Return -1 if no valid numbers were found
    }
}
