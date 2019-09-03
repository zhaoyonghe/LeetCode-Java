package BurstBalloons;
/**
 * Assume nums.length is n.
 * Time Complexity: O(n ^ 3)
 * Space Complexity: O(n ^ 2)
 * Runtime: 29ms
 * Rank: 7.83%
 */
class Solution1 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return nums[0];
        }
        
        // dp[i][j] means the result of nums[i: j]
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[i][i] = get(nums, i - 1) * get(nums, i) * get(nums, i + 1);
        }
        
        for(int len = 1; len < n; len++){
            for(int i = 0; i < n - len; i++){
                int start = i;
                int end = i + len;
                int max = -1;
                
                // get the result of nums[start: end]
                for(int j = start; j <= end; j++){
                	// temp consists of dp[start][j - 1], dp[j + 1][end] 
                	// and get(nums, start - 1) * get(nums, end + 1) * get(nums, j)
                    int temp = 0;
                    if(j > start){
                        temp += dp[start][j - 1];
                    }
                    
                    if(j < end){
                        temp += dp[j + 1][end];
                    }
                    
                    temp += get(nums, start - 1) * get(nums, end + 1) * get(nums, j);
                    max = Math.max(max, temp);
                }
                dp[start][end] = max;
            }
        }
        
        return dp[0][n - 1];
    }
    
    public int get(int[] nums, int i){
        if(i == -1 || i == nums.length){
            return 1;
        }
        
        return nums[i];
    }
}
