package StreamOfCharacters_1032;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Assume the size of the cache is n.
 * Constructor Time Complexity: O(amount of characters in words)
 * query() Time Complexity: O(times of previous query call)
 * Space Complexity: O(amount of characters in words)
 * Runtime: 95ms
 * Rank: 94.02%
 */
public class StreamChecker1 {

    private class Node {
        // All letters are lowercase.
        Node[] next = new Node[26];
        boolean end;
    }

    Node root = new Node();
    List<Integer> stream = new ArrayList<>();

    public StreamChecker1(String[] words) {
        for (String s : words) {
            char[] cs = s.toCharArray();
            Node cur = root;
            int i = cs.length - 1;
            while (true) {
                int index = (int) cs[i] - (int) 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
                if (i == 0) {
                    cur.end = true;
                    break;
                }
                i--;
            }
        }
    }

    public boolean query(char letter) {
        stream.add((int) letter - (int) 'a');
        ListIterator<Integer> it = stream.listIterator(stream.size());
        Node cur = root;
        while (it.hasPrevious()) {
            cur = cur.next[it.previous()];
            if (cur == null) {
                return false;
            }
            if (cur.end) {
                return true;
            }
        }
        return false;
    }
}