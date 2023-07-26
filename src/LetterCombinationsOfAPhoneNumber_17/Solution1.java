package LetterCombinationsOfAPhoneNumber_17;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume n is digits.length().
 * $$ Time Complexity: O(3 ^ n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    private final char[][] buttons = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return res;
        }
        helper(new char[digits.length()], 0, digits.toCharArray(), res);
        return res;
    }
    private void helper(char[] cur, int i, char[] digits, List<String> res) {
        if (i == digits.length) {
            res.add(new String(cur));
            return;
        }
        for (char c: buttons[digits[i]-'2']) {
            cur[i] = c;
            helper(cur, i+1, digits, res);
        }
    }
}
