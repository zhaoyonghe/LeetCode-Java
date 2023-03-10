package TopKFrequentElements_347;

import java.util.*;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n * logk)
 * Space Complexity: O(n)
 * Runtime: 8ms
 * Rank: 93.81%
 */
public class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        // Important constraints:
        // 1 <= nums.length <= 10^5 (input is valid; minus will not overflow)
        // k is in the range [1, the number of unique elements in the array]. (answer always exists)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.compute(num, (key,val)->(val==null?1:val+1));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        map.forEach((key,val)->{
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
