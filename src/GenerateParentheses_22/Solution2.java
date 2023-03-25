package GenerateParentheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Time Complexity: O(4^n/n^(1/2))
 * $$ Space Complexity: O(n)
 */

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(new char[2*n], 0, n, n, res);
        return res;
    }

    private void generate(char[] cur, int i, int le, int ri, List<String> res) {
        if (cur.length == i) {
            res.add(new String(cur));
            return;
        }
        // le > ri cannot happen
        if (le < ri) {
            if (le > 0) {
                cur[i] = '(';
                generate(cur, i+1, le-1, ri, res);
            }
            cur[i] = ')';
            generate(cur, i+1, le, ri-1, res);
            return;
        }
        // le == ri
        // have to put (
        cur[i] = '(';
        generate(cur, i+1, le-1, ri, res);
        return;
    }
}