package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is digits.length().
 * Time Complexity: O(3 ^ n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 70.77%
 */
public class Solution1 {
    String[] buttons = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        StringBuilder sb = new StringBuilder();
        add(ret, sb, 0, digits);
        return ret;
    }

    public void add(List<String> list, StringBuilder sb, int i, String digits) {
        if (i == digits.length()) {
            list.add(sb.toString());
            return;
        }
        int index = digits.charAt(i) - '2';
        for (char c : buttons[index].toCharArray()) {
            sb.append(c);
            add(list, sb, i + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
