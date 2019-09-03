package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(4 ^ n / n ^ (1 / 2))
 * Space Complexity: O(4 ^ n / n ^ (1 / 2))
 * Runtime: 6ms
 * Rank: 65.32%
 */

class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        if(start > end){
            list.add(null);
            return list;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            
            for(TreeNode le: leftTrees){
                for(TreeNode ri: rightTrees){
                    TreeNode cur = new TreeNode(i);
                    cur.left = le;
                    cur.right = ri;
                    list.add(cur);
                }
            }
        }
        
        return list;
    }
}