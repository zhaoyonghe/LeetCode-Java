package DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Assume the numbers of numbers in the input is n.
 * Time Complexity: O(n ^ 4)
 * Space Complexity: O(n ^ 2)
 * Runtime: 10ms
 * Rank: 5.38%
 */

public class Solution1 {
    public List<List<List<Integer>>> memo = null;

    public List<Integer> diffWaysToCompute(String input) {
        List<String> numss = Arrays.asList(input.split("\\+|-|\\*"));
        List<String> signs = Arrays.asList(input.split("[0-9]+"));

        List<Integer> nums = numss.stream().map(ns -> Integer.valueOf(ns)).collect(Collectors.toList());
        if (nums.size() == 1) {
            return nums;
        }

        signs = signs.subList(1, signs.size());

        memo = new ArrayList<>();
        for (int i = 0; i <= nums.size(); i++) {
            memo.add(new ArrayList<>());
            List<List<Integer>> mm = memo.get(i);
            for (int j = 0; j <= nums.size(); j++) {
                mm.add(new ArrayList<>());
            }
        }

        // System.out.println(nums);
        // System.out.println(signs);
        return diffWaysToCompute(nums, signs, 0, nums.size(), 0, signs.size());
    }

    public List<Integer> diffWaysToCompute(List<Integer> nums, List<String> signs, int ns, int ne, int ss, int se) {
        if (ne - ns == 1) {
            // System.out.println(ns + " " + ne);
            return nums.subList(ns, ne);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = ns + 1; i < ne; i++) {
            List<Integer> result0i = memo.get(ns).get(i);
            if (result0i.size() == 0) {
                result0i = diffWaysToCompute(nums, signs, ns, i, ss, i - 1);
            }

            List<Integer> resultin = memo.get(i).get(ne);
            if (resultin.size() == 0) {
                resultin = diffWaysToCompute(nums, signs, i, ne, i, se);
            }

            memo.get(ns).set(i, result0i);
            memo.get(i).set(ne, resultin);
            result.addAll(compute(result0i, resultin, signs.get(i - 1)));
        }

        return result;
    }

    public List<Integer> compute(List<Integer> nums1, List<Integer> nums2, String sign) {
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                if (sign.equals("+")) {
                    nums.add(nums1.get(i) + nums2.get(j));
                } else if (sign.equals("-")) {
                    nums.add(nums1.get(i) - nums2.get(j));
                } else if (sign.equals("*")) {
                    nums.add(nums1.get(i) * nums2.get(j));
                }
            }
        }

        return nums;
    }
}
