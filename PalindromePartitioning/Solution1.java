package PalindromePartitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Assume s.length() is n.
 * Time Complexity: O(2 ^ n)
 * Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 71.45%
 */

public class Solution1 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        LinkedList<String> cur = new LinkedList<>();

        partition(s, cur, list);

        return list;
    }

    @SuppressWarnings("unchecked")
    public void partition(String s, LinkedList<String> cur, List<List<String>> list) {
        if (s.length() == 0) {
            list.add((LinkedList<String>) cur.clone());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(0, i + 1);
            if (isPalindrome(ss)) {
                cur.offerLast(ss);
                partition(s.substring(i + 1, s.length()), cur, list);
                cur.pollLast();
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
