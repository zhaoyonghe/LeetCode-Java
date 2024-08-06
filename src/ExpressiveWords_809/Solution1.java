package ExpressiveWords_809;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the count of all characters in s and words.
 * Assume m is the max length of all strings in s and words.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(m)
 * Runtime: 6ms
 * Rank: 22.72%
 */

public class Solution1 {
    public int expressiveWords(String s, String[] words) {
        List<Character> sChars = new ArrayList<>();
        List<Integer> sCnts = new ArrayList<>();
        feature(s, sChars, sCnts);

        int res = 0;
        for (String word : words) {
            List<Character> wordChars = new ArrayList<>();
            List<Integer> wordCnts = new ArrayList<>();
            feature(word, wordChars, wordCnts);
            if (sChars.size() != wordChars.size()) {
                continue;
            }
            int add = 1;
            for (int i = 0; i < sChars.size(); i++) {
                char sChar = sChars.get(i);
                int sCharCnt = sCnts.get(i);
                char wordChar = wordChars.get(i);
                int wordCharCnt = wordCnts.get(i);

                if (sChar != wordChar || sCharCnt < wordCharCnt || (sCharCnt < 3 && sCharCnt != wordCharCnt)) {
                    add = 0;
                    break;
                }
            }
            res += add;
        }

        return res;
    }

    private void feature(String word, List<Character> cs, List<Integer> cnts) {
        char[] ca = word.toCharArray();
        char prevc = ca[0];
        int cnt = 1;
        for (int i = 1; i < ca.length; i++) {
            if (prevc == ca[i]) {
                cnt++;
                continue;
            }
            cs.add(prevc);
            cnts.add(cnt);
            prevc = ca[i];
            cnt = 1;
        }
        cs.add(prevc);
        cnts.add(cnt);
    }
}