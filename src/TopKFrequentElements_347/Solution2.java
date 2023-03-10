package TopKFrequentElements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n * logk)
 * Space Complexity: O(n)
 * Runtime: 33ms
 * Rank: 75.37%
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

        if (k == 1) {
            int num = 0;
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > count) {
                    num = entry.getKey();
                    count = entry.getValue();
                }
            }
            List<Integer> result = new ArrayList<>();
            result.add(num);
            return result;
        }

        nums = new int[k + 1];
        int[] counts = new int[k + 1];

        int index = 1;
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            nums[index] = entry.getKey();
            counts[index] = entry.getValue();
            index += 1;
            it.remove();
            if (index > k) {
                break;
            }
        }

        // maintain two heaps
        // these two heaps should be modified at the same way
        for (int i = k / 2; i > 0; i--) {
            heapify(nums, counts, i, k);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > counts[1]) {
                nums[1] = entry.getKey();
                counts[1] = entry.getValue();
                heapify(nums, counts, 1, k);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (k > 0) {
            result.add(nums[1]);
            nums[1] = nums[k];
            counts[1] = counts[k];
            k -= 1;
            heapify(nums, counts, 1, k);
        }

        return result;
    }

    public void heapify(int[] nums, int[] counts, int i, int k) {
        while (true) {
            int index = i;
            if (i * 2 <= k && counts[i * 2] < counts[index]) {
                index = i * 2;
            }
            if (i * 2 + 1 <= k && counts[i * 2 + 1] < counts[index]) {
                index = i * 2 + 1;
            }
            if (i == index) {
                break;
            }
            swap(nums, counts, i, index);
            i = index;
        }
    }

    public void swap(int[] nums, int[] counts, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        temp = counts[i];
        counts[i] = counts[j];
        counts[j] = temp;
    }
}
