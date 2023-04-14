package SearchSuggestionsSystem_1268;

import java.util.*;

/**
 * Assume all characters in products is m and searchWord length is n.
 * $$ Time Complexity: O(m + n)
 * $$ Space Complexity: O(m + n)
 */

public class Solution1 {
    class Node {
        Node[] next = new Node[26];
        List<Integer> suggests = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        Node cur = root;

        for (int i = 0; i < products.length; i++) {
            String s = products[i];
            cur = root;
            for (char c : s.toCharArray()) {
                if (cur.next[c-'a'] == null) {
                    cur.next[c-'a'] = new Node();
                }
                cur = cur.next[c-'a'];
                cur.suggests.add(i);
                Collections.sort(cur.suggests, (a, b)->products[a].compareTo(products[b]));
                if (cur.suggests.size() == 4) {
                    cur.suggests.remove(3);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();

        cur = root;
        for (char c : searchWord.toCharArray()) {
            if (cur.next[c-'a'] == null) {

                break;
            }
            cur = cur.next[c-'a'];
            res.add(cur.suggests.stream().map(a->products[a]).toList());
        }

        while (res.size() < searchWord.length()) {
            res.add(new ArrayList<>());
        }

        return res;
    }
}
