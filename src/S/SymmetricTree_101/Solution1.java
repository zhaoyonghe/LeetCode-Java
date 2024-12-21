package S.SymmetricTree_101;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 10ms
 * Rank: 83.52%
 */
public class Solution1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(list);
    }

    // Level order traversal this tree, and check if each level is palindromic.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<List<Integer>> list = levelOrder(root);
        for (int level = 1; level < list.size(); level++) {
            List<Integer> levelNodes = list.get(level);
            for (int i = 0; i < levelNodes.size() / 2; i++) {
                if (levelNodes.get(i) != levelNodes.get(levelNodes.size() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        addList(result, root, 0);
        return result;
    }

    public void addList(List<List<Integer>> list, TreeNode root, int level) {
        // If the max index of list smaller than level.
        if (list.size() - 1 < level) {
            list.add(new ArrayList<>());
        }
        if (root == null) {
            list.get(level).add(null);
        } else {
            list.get(level).add(root.val);
            addList(list, root.left, level + 1);
            addList(list, root.right, level + 1);
        }
    }

}
