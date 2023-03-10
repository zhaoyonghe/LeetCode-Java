package ReorganizeString_767;

/**
 * Time Complexity: O(s.length())
 * Space Complexity: O(s.length())
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    // Important constraints:
    // 1. s consists of lowercase English letters.
    public String reorganizeString(String s) {
        char[] hash = new char[26];
        for (char c : s.toCharArray()) {
            hash[(int) c - (int) 'a']++;
        }

        int i = 0;
        for (int j = 0; j < 26; j++) {
            if (hash[i] < hash[j]) {
                i = j;
            }
        }

        if ((s.length() + 1) / 2 < hash[i]) {
            return "";
        }

        char[] res = new char[s.length()];
        int j = 0;
        while (hash[i] > 0) {
            res[j] = (char) ((int) 'a' + i);
            hash[i]--;
            j += 2;
        }

        for (int k = 0; k < 26; k++) {
            while (hash[k] > 0) {
                if (j >= res.length) {
                    j = 1;
                }
                res[j] = (char) ((int) 'a' + k);
                hash[k]--;
                j += 2;
            }
        }
        return new String(res);
    }
}