package ShortestWordDistanceII_244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Assume n is wordsDict.length; m is the max value among wordsDict[i].length.
 * Constructor Time Complexity: O(n)
 * shortest Time Complexity: O(n)
 * Space Complexity: O(m * n)
 * Runtime: 23ms
 * Rank: 98.84%
 */


class WordDistance1 {
    // Important constraints:
    // 1. word1 and word2 are in wordsDict (always have answer).

    Map<String, List<Integer>> m = new HashMap<>();

    public WordDistance1(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> li = m.getOrDefault(wordsDict[i], new ArrayList<>());
            li.add(i);
            m.put(wordsDict[i], li);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> li1 = m.get(word1);
        List<Integer> li2 = m.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < li1.size() && j < li2.size(); ) {
            int a = li1.get(i);
            int b = li2.get(j);
            if (a < b) {
                res = Math.min(res, b - a);
                i++;
            } else if (a > b) {
                res = Math.min(res, a - b);
                j++;
            } else {
                return 0;
            }
        }
        return res;
    }
}