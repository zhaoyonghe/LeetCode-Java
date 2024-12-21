package F.FindTheCelebrity_277;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 16ms
 * Rank: 87.67%
 */
public class Solution1 {
    private boolean knows(int a, int b) {
        return false;
    }

    public int findCelebrity(int n) {
        // n >= 2, so i, j are valid.
        int i = 0;
        int j = 1;
        while (j < n) {
            if (knows(i, j)) {
                i = j;
            }
            j++;
        }
        j = 0;
        for (; j < n; j++) {
            if ((i != j && knows(i, j)) || !knows(j, i)) {
                return -1;
            }
        }
        return i;
    }
}