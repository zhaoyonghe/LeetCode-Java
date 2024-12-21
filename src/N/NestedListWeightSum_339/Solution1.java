package N.NestedListWeightSum_339;

import java.util.List;

/**
 * Time Complexity: O(nestedList.length)
 * Space Complexity: O(nestedList.length)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    // Important constraints:
// 1. 1 <= nestedList.length <= 50
//    The values of the integers in the nested list is in the range [-100, 100].
//    (weight sum will not overflow)
// 2. The maximum depth of any integer is less than or equal to 50. (recursive level will not go so deep)
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
                continue;
            }
            sum += helper(ni.getList(), level + 1);
        }
        return sum;
    }
}