package S.ShortestWordDistance_243;

/**
 * Assume n is wordsDict.length; m is the max value among wordsDict[i].length.
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.87%
 */

public class Solution1 {
    // Important constraints:
    // 1. word1 and word2 are in wordsDict (always have answer).
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int a = -1;
        int b = -1;
        int res = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                a = i;
                if (b >= 0) {
                    res = Math.min(res, a - b);
                }
            }
            if (wordsDict[i].equals(word2)) {
                b = i;
                if (a >= 0) {
                    res = Math.min(res, b - a);
                }
            }
        }
        return res;
    }
}