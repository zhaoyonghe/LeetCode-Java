package SubsetsI;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(2 ^ n * n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 43.31%
 */
public class Solution1 {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> retList = new ArrayList<>();
	        List<Integer> subset = new ArrayList<>();
	        addSubsets(nums, 0, retList, subset);
	        return retList;
	    }
	    
	    
	    public void addSubsets(int[] nums, int start, List<List<Integer>> list, List<Integer> subset){
	        if(start == nums.length){
	            List<Integer> csubset = new ArrayList<>();
	            for(Integer i: subset){
	                csubset.add(i);
	            }
	            list.add(csubset);
	            return;
	        }
	        // do not choose nums[start]
	        addSubsets(nums, start + 1, list, subset);
	        // choose nums[start]
	        subset.add(nums[start]);
	        addSubsets(nums, start + 1, list, subset);
	        subset.remove(subset.size() - 1);
	        
	    }

}
