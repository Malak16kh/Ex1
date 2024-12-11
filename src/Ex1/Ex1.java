package Ex1;

public class Ex1 {
    /**
     * Checks if a given string represents a valid number format.
     * A valid number must follow the pattern: <number><b><base>.
     * Example: "101b2" (binary), "ABb16" (hexadecimal).
     * Invalid examples: "b2", "123b", "GbG".
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false; // A null or empty string cannot be a valid number.
        }
        // Regular expression to match the valid number format.
        String regex = "^[0-9A-F]+b[2-9A-G]$";
        return a.matches(regex);
    }

    /**
     * Converts a valid number string to its decimal (base 10) value.
     * If the string is invalid, returns -1.
     * Example: "1011b2" -> 11 (binary to decimal).
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1; // Return -1 for invalid numbers.
        }
        // Separate the number and base parts.
        int indexOfB = num.indexOf('b');
        String numberPart = num.substring(0, indexOfB); // The digits.
        String basePart = num.substring(indexOfB + 1); // The base.
        int base = Character.isDigit(basePart.charAt(0)) ? Integer.parseInt(basePart) : basePart.charAt(0) - 'A' + 10;

        // Convert the number part to decimal.
        int result = 0;
        for (char digit : numberPart.toCharArray()) {
            int value = Character.isDigit(digit) ? digit - '0' : digit - 'A' + 10;
            result = result * base + value;
        }
        return result;
    }

    /**
     * Converts a decimal number to its representation in a given base.
     * If the input number is negative or the base is invalid, returns an empty string.
     * Example: 11 in base 2 -> "1011".
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return ""; // Return an empty string for invalid input.
        }
        StringBuilder result = new StringBuilder();
        // Convert using repeated division and remainders.
        do {
            int remainder = num % base;
            if (remainder < 10) {
                result.append((char) ('0' + remainder));
            } else {
                result.append((char) ('A' + remainder - 10));
            }
            num /= base;
        } while (num > 0);
        return result.reverse().toString(); // Reverse to get the correct order.
    }

    /**
     * Checks if two numbers in string format are equal in value.
     * Example: "1011b2" and "11b10" are equal (both are 11 in decimal).
     */
    public static boolean equals(String n1, String n2) {
        if (!isNumber(n1) || !isNumber(n2)) {
            return false; // If either number is invalid, return false.
        }
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * Finds the index of the largest number in a given array.
     * If there are multiple largest numbers, returns the first one.
     * Example: ["1011b2", "15b10", "invalid"] -> Index 1 (15 is largest).
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = -1; // Default to -1 if no valid numbers are found.
        int maxValue = Integer.MIN_VALUE; // Smallest possible value initially.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && isNumber(arr[i])) {
                int value = number2Int(arr[i]);
                if (value > maxValue) {
                    maxValue = value;
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }
}


