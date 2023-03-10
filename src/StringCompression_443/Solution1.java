package StringCompression_443;
/**
 * Time Complexity: O(chars.length)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {

    public int compress(char[] chars) {
        int cnt = 1;
        char cur = chars[0];
        int j = 0;
        for (int k = 1; k < chars.length; k++) {
            char c = chars[k];
            if (cur == c) {
                cnt++;
                continue;
            }

            j = put(chars, j, cnt, chars[k-1]);

            cur = c;
            cnt = 1;
        }

        j = put(chars, j, cnt, cur);

        return j;
    }

    private int put(char[] chars, int j, int cnt,char c) {
        chars[j] = c;
        j++;
        int i = j;
        if (cnt > 1) {
            while (cnt > 0) {
                chars[j] = (char)((int)('0')+(cnt%10));
                cnt/=10;
                j++;
            }
            reverse(chars, i, j-1);
        }
        return j;
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }
}