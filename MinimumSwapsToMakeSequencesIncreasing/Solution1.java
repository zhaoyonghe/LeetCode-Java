package MinimumSwapsToMakeSequencesIncreasing;

/**
 * Assume A.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 43.57%
 */
public class Solution1 {
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[N];
        int[] not_swap = new int[N];
        swap[0] = 1;
        for (int i = 1; i < N; ++i) {
            if (A[i] <= A[i - 1] || B[i] <= B[i - 1]) {
                // must swap
                not_swap[i] = swap[i - 1];
                swap[i] = not_swap[i - 1] + 1;
                continue;
            }

            if (A[i] <= B[i - 1] || B[i] <= A[i - 1]) {
                // A[i - 1] < A[i] && B[i - 1] < B[i] && !(A[i - 1] < B[i] && B[i - 1] < A[i])
                // must not swap
                not_swap[i] = not_swap[i - 1];
                swap[i] = swap[i - 1] + 1;
            } else {
                // A[i - 1] < A[i] && B[i - 1] < B[i] && A[i - 1] < B[i] && B[i - 1] < A[i]
                // swap or not swap are both OK
                not_swap[i] = Math.min(swap[i - 1], not_swap[i - 1]);
                swap[i] = Math.min(swap[i - 1], not_swap[i - 1]) + 1;
            }
        }
        //System.out.println(Arrays.toString(not_swap));
        //System.out.println(Arrays.toString(swap));
        return Math.min(swap[N - 1], not_swap[N - 1]);
    }
}
