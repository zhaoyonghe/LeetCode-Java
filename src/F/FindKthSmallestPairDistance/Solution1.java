package F.FindKthSmallestPairDistance;

/**
 * Assume range is max(nums) - min(nums)
 * Time Complexity: O(nums.length + range * log(range))
 * Space Complexity: O(range)
 * Runtime: 267ms
 * Rank: 24.39%
 */
public class Solution1 {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // O(nums.length)
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int range = max - min;

        if (range == 0) {
            return 0;
        }

        if (2 * k == n * (n - 1)) {
            return range;
        }

        // 0 <= distance <= range
        int[] line = new int[range + 1];

        // normalize the numbers and put them onto the line
        for (int num : nums) {
            line[num - min] += 1;
        }
        // System.out.println(Arrays.toString(line));

        int[] records = new int[range + 1];
        for (int i = 0; i <= range; i++) {
            records[i] = -1;
        }

        int low = 0;
        int high = range;
        while (low <= high) {
            int mid = (low + high) / 2;
            // System.out.println(mid);
            // count how many distances are smaller or equal to mid
            // countm1 <= count
            int count = getNumOfPairsHaveDisLEX(records, line, n, range, mid);
            int countm1 = getNumOfPairsHaveDisLEX(records, line, n, range, mid - 1);

            if (count >= k && countm1 < k) {
                // System.out.println(Arrays.toString(records));
                return mid;
            }

            if (count < k) {
                low = mid + 1;
            }

            if (countm1 >= k) {
                high = mid - 1;
            }

        }

        return 0;

    }

    // O(range)
    // get the number of pairs that have distance <= X
    public int getNumOfPairsHaveDisLEX(int[] records, int[] line, int n, int range, int mid) {
        // System.out.println(mid);
        if (mid < 0) {
            return -1;
        }
        int count = 0;
        if (mid >= range) {
            count = (n * (n - 1)) / 2;
        } else {
            if (records[mid] != -1) {
                return records[mid];
            }
            int i = 0;
            int j = mid;
            int points = 0;
            for (int k = 0; k <= j; k++) {
                points += line[k];
            }

            count += ((points * (points - 1)) / 2);
            while (j + 1 <= range) {
                points -= line[i];
                i += 1;
                // new distances that are shorter or equal to mid
                count += (points * line[j + 1]);
                count += ((line[j + 1] * (line[j + 1] - 1)) / 2);
                points += line[j + 1];
                j += 1;
            }
        }
        records[mid] = count;
        // System.out.println(Arrays.toString(records));
        return count;
    }
}
