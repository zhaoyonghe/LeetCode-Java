package IntegerToRoman;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 62ms
 * Rank: 87.61%
 */
public class Solution1 {
    public String[][] table = {{"", "M", "MM", "MMM"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}};

    public String intToRoman(int num) {
        // 1 <= num <= 3999
        // n contains the digits of num.
        // If num = 3456, then n = {3, 4, 5, 6}.
        // If num = 56, then n = {0, 0, 5, 6}.
        int[] n = new int[4];
        for (int i = 3; i > -1; i--) {
            n[i] = num % 10;
            num /= 10;
        }
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += table[i][n[i]];
        }
        return result;
    }

}
