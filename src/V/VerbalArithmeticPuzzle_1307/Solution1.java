package V.VerbalArithmeticPuzzle_1307;

/**
 * $$ Assume the number of different characters is n.
 * $$ Time Complexity: O(n!)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public boolean isSolvable(String[] words, String result) {
        int[] map = new int[26];
        boolean[] cannotZero = new boolean[11];
        int[] left = new int[11];
        int[] right = new int[11];
        int num = 0;
        boolean[] used = new boolean[10];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (map[c - 'A'] == 0) {
                    num += 1;
                    map[c - 'A'] = num;
                }
            }
        }
        for (char c : result.toCharArray()) {
            if (map[c - 'A'] == 0) {
                num += 1;
                map[c - 'A'] = num;
            }
        }

        for (String word : words) {
            if (word.length() > 1) {
                cannotZero[map[word.charAt(0) - 'A']] = true;
            }

        }
        if (result.length() > 1) {
            cannotZero[map[result.charAt(0) - 'A']] = true;
        }


        for (String word : words) {
            int w = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                left[map[word.charAt(i) - 'A']] += w;
                w *= 10;
            }
        }
        int w = 1;
        for (int i = result.length() - 1; i >= 0; i--) {
            right[map[result.charAt(i) - 'A']] += w;
            w *= 10;
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        return dfs(1, num, used, cannotZero, left, right, 0, 0);
    }

    public boolean dfs(int index, int n, boolean[] used, boolean[] cannotZero, int[] left, int[] right, int leftSum,
                       int rightSum) {
        if (index > n) {
            return leftSum == rightSum;
        }

        for (int i = 0; i < 10; i++) {
            if ((cannotZero[index] && i == 0) || used[i]) {
                continue;
            }

            used[i] = true;
            if (dfs(index + 1, n, used, cannotZero, left, right, leftSum + left[index] * i,
                    rightSum + right[index] * i)) {
                return true;
            }
            used[i] = false;
        }

        return false;
    }
}
