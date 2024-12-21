package D.DotProductOfTwoSparseVectors_1570;

import java.util.HashMap;
import java.util.Map;

/**
 * Assume nums.length is n.
 * Constructor Time Complexity: O(n)
 * dotProduct() Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 8ms
 * Rank: 81.72%
 */
public class SparseVector1 {
    // Important constraints:
// 1. n == nums1.length == nums2.length (input is valid)
// 2. 1 <= n <= 10^5
//    0 <= nums1[i], nums2[i] <= 100
//    (result will not overflow)
    public HashMap<Integer, Integer> m = new HashMap();

    SparseVector1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            m.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector1 vec) {
        int product = 0;
        for (Map.Entry<Integer, Integer> en : m.entrySet()) {
            Integer a = vec.m.get(en.getKey());
            if (a == null) {
                continue;
            }
            product += en.getValue() * a;
        }
        return product;
    }
}