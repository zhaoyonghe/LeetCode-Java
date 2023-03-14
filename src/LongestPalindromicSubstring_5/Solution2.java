package LongestPalindromicSubstring_5;

/**
 * $$ Assume n is the length of s.
 * $$ Time Complexity: O(n^2)
 * $$ Space Complexity: O(1)
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        int length = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (length / 2 > s.length() - i) {
                break;
            }
            int oddwing = oddPSLength(s, i);
            int evenwing = evenPSLength(s, i, i + 1);
            int oddlength = 1 + 2 * oddwing;
            int evenlength = 2 * evenwing;
            if (Math.max(oddlength, evenlength) > length) {
                if (oddlength > evenlength) {
                    start = i - oddwing;
                    end = i + oddwing;
                    length = oddlength;
                } else {
                    start = i + 1 - evenwing;
                    end = i + evenwing;
                    length = evenlength;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public int oddPSLength(String s, int center) {
        int start = center - 1;
        int end = center + 1;
        int wing = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                wing++;
                start--;
                end++;
            } else {
                break;
            }
        }
        return wing;
    }

    public int evenPSLength(String s, int center1, int center2) {
        int start = center1;
        int end = center2;
        int wing = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                wing++;
                start--;
                end++;
            } else {
                break;
            }
        }
        return wing;
    }
}
