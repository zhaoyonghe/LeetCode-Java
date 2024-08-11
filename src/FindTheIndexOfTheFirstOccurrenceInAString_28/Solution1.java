package FindTheIndexOfTheFirstOccurrenceInAString_28;

/**
 * $$ Assume the length of haystack is n, the length of needle is m.
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int strStr(String haystack, String needle) {
        // needle is ""
        if (needle.isEmpty()) {
            return 0;
        }
        // needle is not "", but haystack is ""
        if (haystack.isEmpty()) {
            return -1;
        }
        // both needle and haystack are not ""
        if (needle.length() > haystack.length()) {
            return -1;
        } else {
            int i = 0;
            while (i <= haystack.length() - needle.length()) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    if (compareTwoStrings(haystack.substring(i, i + needle.length()), needle)) {
                        return i;
                    }
                }
                i += 1;
            }
        }
        return -1;
    }

    public boolean compareTwoStrings(String a, String b) {
        assert a.length() == b.length();
        int len = a.length();
        for (int i = 1; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
