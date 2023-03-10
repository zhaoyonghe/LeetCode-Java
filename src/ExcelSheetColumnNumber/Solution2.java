package ExcelSheetColumnNumber;

/**
 * Time Complexity: O(s.length())
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.61%
 */
public class Solution2 {
    public int titleToNumber(String s) {
        int sum = 0;
        int i = 0;
        for (; i < s.length() - 1; i++) {
            sum += (s.charAt(i) - 64);
            sum *= 26;
        }
        sum += (s.charAt(i) - 64);
        return sum;
    }
}
