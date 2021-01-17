package LongestPalindromicSubstring;

/**
 * Assume n is the length of s.
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * Runtime: 72ms
 * Rank: 46.89%
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        // Dynamic programming.
        // The matrix's cell is useful only when matrix[i][j](i <= j),
        // indicating whether or not substring between i and j is palindrome.
        int[][] matrix = new int[s.length()][s.length()];
        // It is obivious that matrix[i][i] = 1(true),
        // and the value of matrix[i][i + 1] is also easy to judge.
        // So based on these decided values, we know that:
        // matrix[i][j] = true(when matrix[i + 1][j - 1] == true, and s.charAt(i) == s.charAt(j))
        // matrix[i][j] = false(when matrix[i + 1][j - 1] == false)
        int finalstart = 0;
        int finalend = 0;
        for (int i = 0; i < s.length(); i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                matrix[i][i + 1] = 1;
                finalstart = i;
                finalend = i + 1;
            }
        }
        for (int offset = 2; offset < s.length(); offset++) {
            for (int start = 0; start < s.length() - offset; start++) {
                int end = start + offset;
                if (matrix[start + 1][end - 1] == 0) {
                    matrix[start][end] = 0;
                } else {
                    if (s.charAt(start) == s.charAt(end)) {
                        matrix[start][end] = 1;
                        if (offset > finalend - finalstart) {
                            finalstart = start;
                            finalend = end;
                        }
                    }
                }
            }
        }

        return s.substring(finalstart, finalend + 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
