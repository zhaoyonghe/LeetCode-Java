package T.TopKFrequentElements_347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(nlogk)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, val) -> (val == null ? 1 : val + 1));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        map.forEach((key, val) -> {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
