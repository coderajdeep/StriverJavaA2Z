package Recursion;

public class Solution_01_Atoi_Or_Stoi {
    public int myAtoi(String input) {
        int i = 0, n = input.length();

        // Step 1: Skip leading spaces
        while (i < n && input.charAt(i) == ' ') i++;

        // Step 2: Determine sign
        int sign = 1;
        if (i < n && (input.charAt(i) == '-' || input.charAt(i) == '+')) {
            sign = (input.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Parse digits with overflow check
        int result = 0;
        while (i < n && Character.isDigit(input.charAt(i))) {
            int digit = input.charAt(i) - '0';

            // Overflow check BEFORE updating result
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > (sign == 1 ? 7 : 8))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
