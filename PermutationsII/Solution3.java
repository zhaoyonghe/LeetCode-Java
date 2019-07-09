package PermutationsII;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(n * n!)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 100.00%
 */
public class Solution3 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteUnique(nums, 0, list);
        return list;
    }
    
    public void permuteUnique(int[] nums, int start, List<List<Integer>> list){
        if(start == nums.length - 1){
            List<Integer> tempList = new ArrayList<>(nums.length);
            for(int num: nums){
                tempList.add(num);
            }
            list.add(tempList);
        } else {
            // start < nums.length
            for(int i = start; i < nums.length; i++){
                // do not do useless swap
                boolean isContinue = false;
                for(int j = start; j < i; j++){
                    if(nums[j] == nums[i]){
                    	// nums[i] used to be the first one
                    	// do not swap
                        isContinue = true;
                        break;
                    }
                }
                if(isContinue){
                    continue;
                }
                swap(nums, start, i);
                permuteUnique(nums, start + 1, list);
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
