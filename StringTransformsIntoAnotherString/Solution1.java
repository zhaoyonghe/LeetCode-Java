package StringTransformsIntoAnotherString;

import java.util.Arrays;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean canConvert(String str1, String str2) {
        char[] arr = new char[26];
        Arrays.fill(arr, '0');
        int n = str1.length();

        for (int i = 0; i < n; i++) {
            if (arr[str1.charAt(i) - 'a'] == '0') {
                arr[str1.charAt(i) - 'a'] = str2.charAt(i);
            } else {
                if (arr[str1.charAt(i) - 'a'] != str2.charAt(i)) {
                    return false;
                }
            }
        }

        int count = 0;
        boolean[] f = new boolean[26];
        for (char c : str2.toCharArray()) {
            if (!f[c - 'a']) {
                f[c - 'a'] = true;
                count += 1;
                if (count == 26) {
                    return str1.equals(str2);
                }
            }
        }
        return true;
    }
}
