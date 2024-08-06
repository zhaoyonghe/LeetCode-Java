package IntersectionOfTwoArraysII;

import java.util.Arrays;

/**
 * Assume the length of nums1 is m, that of nums2 is n, m < n;
 * Time Complexity: O(mlogm + nlogm)
 * Space Complexity: O(m)
 * Runtime: 4ms
 * Rank: 87.01%
 */
public class Solution1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution1 s = new Solution1();
        s.intersect(new int[]{2, 2}, new int[]{1, 2, 2, 1});
    }
    // Follow up:
    // What if the given array is already sorted? How would you optimize your algorithm?
    // What if nums1's size is small compared to nums2's size? Which algorithm is better?
    // What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] small = null;
        int[] big = null;
        if (nums1.length < nums2.length) {
            small = nums1;
            big = nums2;
        } else {
            small = nums2;
            big = nums1;
        }
        Arrays.sort(small);
        boolean[] visited = new boolean[small.length];
        int[] result = new int[small.length];
        int index = 0;
        for (int i = 0; i < big.length; i++) {
            // find unvisited big[i] in small
            int low = 0;
            int high = small.length - 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (big[i] < small[mid]) {
                    high = mid - 1;
                } else if (big[i] > small[mid]) {
                    low = mid + 1;
                } else {
                    // big[i] == small[mid]
                    if (!visited[mid]) {
                        // small[mid] is not the last unvisited element that equals to big[i]
                        if (mid + 1 < small.length && (big[i] == small[mid + 1]) && !visited[mid + 1]) {
                            low = mid + 1;
                        } else {
                            visited[mid] = true;
                            result[index] = big[i];
                            index += 1;
                            break;
                        }
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return Arrays.copyOf(result, index);
    }

}
