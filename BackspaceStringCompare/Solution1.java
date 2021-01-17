package BackspaceStringCompare;

/**
 * Time Complexity: O(S.length() + T.length())
 * Space Complexity: O(S.length() + T.length())
 * Runtime: 7ms
 * Rank: 94.75%
 */
public class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        String finalS = "";
        String finalT = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (finalS.length() > 0) {
                    finalS = finalS.substring(0, finalS.length() - 1);
                }
            } else {
                finalS += S.charAt(i);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (finalT.length() > 0) {
                    finalT = finalT.substring(0, finalT.length() - 1);
                }
            } else {
                finalT += T.charAt(i);
            }
        }
        return finalS.equals(finalT);
    }
}
