package RangeSumQueryMutable_307;

/**
 * Assume the length of nums is n.
 * NumArray Time Complexity: O(nlogn)
 * update Time Complexity: O(logn)
 * sumRange Time Complexity: O(logn)
 * Runtime: 84ms
 * Rank: 97.66%
 */

public class NumArray1 {
    private final int[] bitree;
    private final int[] nums;
    private int n;

    public NumArray1(int[] nums) {
        n = nums.length;
        this.bitree = new int[n + 1];
        this.nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            this.nums[i + 1] = nums[i];
        }
        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x <= n) {
                this.bitree[x] += this.nums[i];
                x += (x & -x);
            }
        }
    }

    public void update(int index, int val) {
        index++;
        int diff = val - this.nums[index];
        int x = index;
        while (x <= n) {
            this.bitree[x] += diff;
            x += (x & -x);
        }
        this.nums[index] += diff;
    }

    private int get(int up) {
        int res = 0;
        while (up > 0) {
            res += this.bitree[up];
            up -= (up & -up);
        }
        return res;
    }

    public int sumRange(int left, int right) {
        right++;
        return get(right) - get(left);
    }
}
