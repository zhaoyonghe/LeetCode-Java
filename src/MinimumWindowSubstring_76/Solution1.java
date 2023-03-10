package MinimumWindowSubstring_76;
/**
 * Time Complexity: O(max(s.length, t.length))
 * Space Complexity: O(1)
 * Runtime: 26ms
 * Rank: 36.68%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= s.length, t.length <= 10 ^ 5.
    // 2. s and t consist of uppercase and lowercase English letters.
    public String minWindow(String s, String t) {
        int[] record = new int[128];
        int[] target = new int[128];
        for (char c : t.toCharArray()) {
            target[(int)(c)]++;
        }
        int[] se = new int[2];
        int[] res = new int[2];
        char[] ss = s.toCharArray();
        while(true){
            if (!extend(ss,se,record,target)) {
                break;
            }
            shrink(ss,se,record,target);
            if ((res[1]==0&&res[0]==0)||res[1]-res[0]>se[1]-se[0]) {
                res[0]=se[0];
                res[1]=se[1];
            }
            record[(int)(ss[se[0]])]--;
            se[0]++;
        }
        return s.substring(res[0],res[1]);
    }

    // extend increases se[1] until satisfied amd return true. Return false if cannot.
    private boolean extend(char[] s, int[] se, int[] record, int[] target) {
        for (;se[1]<s.length;se[1]++){
            if (target[(int)(s[se[1]])]==0){
                continue;
            }
            record[(int)(s[se[1]])]++;
            if (satisfied(record, target)) {
                se[1]++;
                return true;
            }
        }
        return false;
    }

    // s[se[0]:se[1]] already satisfied.
    private void shrink(char[] s, int[] se, int[] record, int[] target) {
        for (;;se[0]++){
            if (target[(int)(s[se[0]])]==0){
                continue;
            }
            record[(int)(s[se[0]])]--;
            if (!satisfied(record, target)) {
                record[(int)(s[se[0]])]++;
                break;
            }
        }
        return;
    }

    private boolean satisfied(int[] record, int[] target) {
        // assert record.length == target.length == 128
        for (int i = 0; i < record.length; i++) {
            if (record[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}