package I.IntersectionOfTwoArraysI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Assume the length of nums1 is m, that of nums2 is n.
 * Time Complexity: O(m + n)
 * Space Complexity: O(min(m, n))
 * Runtime: 3ms
 * Rank: 96.87%
 */
public class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.remove(num);
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
