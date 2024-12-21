package T.TopKFrequentElements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // list[i] stores the list of numbers that has frequency of i
        List<Integer>[] list = new List[nums.length];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (list[entry.getValue() - 1] == null) {
                list[entry.getValue() - 1] = new ArrayList<>();
            }
            list[entry.getValue() - 1].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();

        // k is always valid
        // do not need to truncate the result
        for (int i = nums.length - 1; i >= 0 && result.size() < k; i--) {
            if (list[i] != null) {
                result.addAll(list[i]);
            }
        }

        return result;
    }
}
