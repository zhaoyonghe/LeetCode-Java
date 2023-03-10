package BaseballGame;

/**
 * Assume n is ops.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 7ms
 * Rank: 81.38%
 */
public class Solution1 {
    public int calPoints(String[] ops) {
        int[] valid = new int[ops.length];
        int index = -1;
        int sum = 0;
        for (String op : ops) {
            switch (op) {
                case "C":
                    sum = sum - valid[index];
                    index -= 1;
                    break;
                case "D":
                    index += 1;
                    valid[index] = valid[index - 1] * 2;
                    sum = sum + valid[index];
                    break;
                case "+":
                    index += 1;
                    valid[index] = valid[index - 1] + valid[index - 2];
                    sum = sum + valid[index];
                    break;
                default:
                    index += 1;
                    valid[index] = Integer.valueOf(op);
                    sum = sum + valid[index];
                    break;
            }
        }
        return sum;
    }
}
