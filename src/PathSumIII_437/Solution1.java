package PathSumIII_437;

import java.util.*;

/**
 * $$ Assume the number of the tree nodes is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put((long)0, 1);
        countPaths(root, targetSum, 0, prefixSum);
        return this.count;
    }

    private int count = 0;

    private void countPaths(TreeNode root, long sum, long cur, Map<Long, Integer> prefixSum) {
        if (root == null) {
            return;
        }

        cur+=(long)root.val;

        this.count +=prefixSum.getOrDefault(cur - sum, 0);

        prefixSum.compute(cur, (k,v)->v==null?1:v+1);
        countPaths(root.left, sum, cur, prefixSum);
        countPaths(root.right, sum, cur, prefixSum);
        prefixSum.compute(cur, (k,v)->v==1?null:v-1);
    }
}
