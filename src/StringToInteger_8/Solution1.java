package StringToInteger_8;

/**
 * $$ Assume n is str.length().
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
class Solution1 {
    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        int len = str.length();

        int i = 0;

        // overlook the whitespace
        while (i < len && str.charAt(i) == ' ') {
            i += 1;
        }

        // the case when all characters are whitespaces
        if (i == len) {
            return 0;
        }

        // the first non-whitespace character is not '-''+' and not a digit
        if (str.charAt(i) != '-' && str.charAt(i) != '+' && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
            return 0;
        }

        boolean isMinus = false;

        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            // if there is no character after the first '-''+'
            // or
            // the character after the first '-' is not a digit.
            if (i + 1 == len || (str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9')) {
                return 0;
            }

            isMinus = str.charAt(i) == '-';

            i += 1;
        }

        long result = 0;
        int digitCount = 0;

        while (i < len) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }

            result *= 10;
            result += (str.charAt(i) - '0');

            digitCount = result != 0 ? digitCount + 1 : digitCount;

            // avoid the super-long string
            if (digitCount == 11) {
                break;
            }

            i += 1;
        }

        if (isMinus) {
            result = -result;
        }

        if (result > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
