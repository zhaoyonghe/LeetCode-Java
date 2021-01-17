package MedianOfTwoSortedArrays;

/**
 * Time Complexity: O(log(min(nums1.length, nums2.length)))
 * Space Complexity: O(1)
 * Runtime: 71ms
 * Rank: 59.87%
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        if (nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }
        int alen = A.length, blen = B.length;
        if (alen == 0) {
            if (blen == 0) {
                return 0;
            } else {
                if ((blen & 1) == 0) {
                    return (double) (B[(blen >> 1) - 1] + B[blen >> 1]) / 2;
                } else {
                    return B[blen >> 1];
                }
            }
        } else {
            int s = (alen + blen + 1) >> 1;
            int minaleft = 0;
            int maxaleft = alen;
            while (true) {
                int aleft = (minaleft + maxaleft) >> 1;
                int bleft = s - aleft;
                int aleftmax = leftMax(A, aleft);
                int arightmin = rightMin(A, aleft);
                int bleftmax = leftMax(B, bleft);
                int brightmin = rightMin(B, bleft);
                if (aleftmax <= brightmin && bleftmax <= arightmin) {
                    if (((alen + blen) & 1) == 0) {
                        return (double) (Math.max(aleftmax, bleftmax) + Math.min(arightmin, brightmin)) / 2;
                    } else {
                        return Math.max(aleftmax, bleftmax);
                    }
                } else if (aleftmax > brightmin) {
                    maxaleft = aleft - 1;
                } else {
                    // if bleftmax > arightmin
                    minaleft = aleft + 1;
                }

            }
        }
    }

    public int leftMax(int[] nums, int left) {
        assert left <= nums.length;
        if (left == 0) {
            return Integer.MIN_VALUE;
        } else {
            return nums[left - 1];
        }
    }

    public int rightMin(int[] nums, int left) {
        assert left <= nums.length;
        if (left == nums.length) {
            return Integer.MAX_VALUE;
        } else {
            return nums[left];
        }
    }

    public static void main(String[] args) {
        System.out.println((double) (2 + 7) / 2);
    }

}
