package PermutationsI;
/**
 * Assume n is nums.length.
 * Time Complexity: O(n!)
 * Space Complexity: O(n^2)
 * Runtime: 16ms
 * Rank: 5.58%
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution1 {
    public int[] nfactorial = null;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        nfactorial = new int[n + 1];
        nfactorial[0] = 1;
        nfactorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            nfactorial[i] = nfactorial[i - 1] * i;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nfactorial[n]; i++) {
            list.add(new ArrayList<Integer>());
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        fill(list, set, 0);
        return list;
    }

    public void fill(List<List<Integer>> list, HashSet<Integer> set, int platform) {
        int n = set.size();
        if (n == 0) {
            return;
        }
        int count = 0;
        for (int num : set) {
            for (int offset = 0; offset < nfactorial[n - 1]; offset++) {
                list.get(platform + count * nfactorial[n - 1] + offset).add(num);
            }
            @SuppressWarnings("unchecked")
            HashSet<Integer> cset = (HashSet<Integer>) set.clone();
            cset.remove(num);
            fill(list, cset, platform + count * nfactorial[n - 1]);
            count++;
        }
    }
}
