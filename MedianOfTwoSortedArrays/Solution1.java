package MedianOfTwoSortedArrays;

import java.util.Arrays;

public class Solution1 {
	public double findNoKBiggestNum(int[] nums, int start, int end, int K)throws Exception {
		int len = end - start + 1;
		if(len < 1) {
			throw new Exception("Illegal input: no number in array!");
		}
		if(len < K) {
			throw new Exception("K is bigger than the length of array!");
		}
		int pivot = end;
		int i = start;
		int j = start;
		int temp;
		for(; j < pivot; j++) {
			if(nums[j] > nums[pivot]) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		temp = nums[i];
		nums[i] = nums[pivot];
		nums[pivot] = temp;
		pivot = i;
		// nums[pivot] is the No.k biggest number in nums[start to end]
		int k = pivot - start + 1;
		System.out.println("=======================");
		System.out.println(Arrays.toString(nums));
		System.out.println(K);
		System.out.println(k);
		System.out.println("=======================");
		if(k > K) {
			// pivot - 1 - start + 1 = k - 1 >= K
			return findNoKBiggestNum(nums, start, pivot - 1, K);
		}else if(k < K) {
			// end - pivot - 1 + 1 >= K - k
			return findNoKBiggestNum(nums, pivot + 1, end, K - k);
		} else {
			return nums[pivot];
		}
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return 9;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		int[] a = {1,2,3,3,4,4,5,6,7,9,9,9,8,9};
		System.out.println(s.findNoKBiggestNum(a, 0, 13, 5));
	}

}
