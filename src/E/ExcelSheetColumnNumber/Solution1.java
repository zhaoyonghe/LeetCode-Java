package E.ExcelSheetColumnNumber;

/**
 * Time Complexity: O(s.length())
 * Space Complexity: O(1)
 * Runtime: 6ms
 * Rank: 82.97%
 */
public class Solution1 {
    public int titleToNumber(String s) {
        int sum = 0;
        int mul = 1;
        for (int i = 1; i <= s.length(); i++) {
            sum += mul * (s.charAt(s.length() - i) - 64);
            mul *= 26;
        }
        return sum;
    }
}
