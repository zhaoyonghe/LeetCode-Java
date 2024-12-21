package W.WordLadderI_127;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Assume wordList.size() is n and length of words in wordList is len.
 * Time Complexity: O(n ^ 2 * len)
 * Space Complexity: O(n ^ 2)
 * Runtime: 487ms
 * Rank: 24.53%
 */
public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // n = wordList.size()
        // len = words' length
        // O(n)
        if (!wordList.contains(endWord)) {
            return 0;
        }

        HashMap<String, HashSet<String>> graph = new HashMap<>();

        // O(n ^ 2 * len)
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String a = wordList.get(i);
                String b = wordList.get(j);
                if (oneLetterDiff(a, b)) {
                    graph.putIfAbsent(a, new HashSet<String>());
                    graph.putIfAbsent(b, new HashSet<String>());

                    graph.get(a).add(b);
                    graph.get(b).add(a);
                }
            }
        }

        // O(n * len)
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            if (oneLetterDiff(s, beginWord)) {
                set.add(s);
            }
        }
        graph.put(beginWord, set);

        // O(|V|+|E|) = O(n ^ 2)
        int path = 2;
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord);
        while (queue.size() != 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String node = queue.poll();
                visited.add(node);
                for (String nei : graph.get(node)) {
                    if (!visited.contains(nei)) {
                        if (nei.equals(endWord)) {
                            return path;
                        } else {
                            queue.offer(nei);
                        }
                    }
                }
            }
            path += 1;
        }

        return 0;
    }

    public boolean oneLetterDiff(String a, String b) {
        // assert a.length() == b.length();
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count += 1;
            }
        }
        return count == 1;
    }
}
