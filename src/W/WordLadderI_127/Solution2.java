package W.WordLadderI_127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Assume wordList.size() is n and length of words in wordList is len.
 * Time Complexity: O(n * 26 ^ len)
 * Space Complexity: O(n * len)
 * Runtime: 41ms
 * Rank: 87.98%
 */

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        a.add(beginWord);
        b.add(endWord);

        int step = 0;

        Set<String> all = new HashSet<>();

        while (!a.isEmpty() && !b.isEmpty()) {
            step++;

            Set<String> next = new HashSet<>();
            for (String cur : a) {
                for (int i = 0; i < cur.length(); i++) {
                    char[] arr = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String nextStr = new String(arr);
                        if (!wordSet.contains(nextStr)) {
                            continue;
                        }
                        if (b.contains(nextStr)) {
                            return step + 1;
                        }
                        if (all.contains(nextStr)) {
                            continue;
                        }
                        next.add(nextStr);
                        all.add(nextStr);
                    }
                }
            }
            a = b;
            b = next;
        }

        return 0;

    }
}
