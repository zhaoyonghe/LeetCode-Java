package PermutationsI;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(n * n!)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 90.92%
 */
public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(nums, 0, list);
        return list;
    }
    
    public void permute(int[] nums, int start, List<List<Integer>> list){
        if(start == nums.length - 1){
            List<Integer> tempList = new ArrayList<Integer>(nums.length);
            for(int num: nums){
                tempList.add(num);
            }
            list.add(tempList);
        } else {
        	// This loop let each element in nums be the first element.
            // start < nums.length - 1
            for(int i = start; i < nums.length; i++){
                swap(nums, start, i);
                permute(nums, start + 1, list);
                swap(nums, start, i);
            }
        }
        
    }
    
    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
