package ClosestBinarySearchTreeValueII_272;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Assume h is the height of root.
 * Time Complexity: O(k + h)
 * Auxiliary Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 96.22%
 */
public class Solution1 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        TreeNode largestSmaller = null;
        TreeNode smallestLarger = null;
        TreeNode cur = root;
        // set largestSmaller
        while (cur != null) {
            if ((double) cur.val < target) {
                largestSmaller = cur;
                cur = cur.right;
            } else if ((double) cur.val > target) {
                cur = cur.left;
            } else {
                largestSmaller = cur;
                break;
            }
        }
        cur = root;
        // set smallestLarger
        while (cur != null) {
            if ((double) cur.val < target) {
                cur = cur.right;
            } else if ((double) cur.val > target) {
                smallestLarger = cur;
                cur = cur.left;
            } else {
                smallestLarger = cur;
                break;
            }
        }
        // largestSmaller.val <= target <= smallestLarger.val
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> ascTraverseSt = initSt(root, smallestLarger);
        Deque<TreeNode> descTraverseSt = initSt(root, largestSmaller);
        TreeNode small = peek(descTraverseSt);
        TreeNode large = peek(ascTraverseSt);
        if (small == large) {
            large = next(ascTraverseSt);
        }
        while (k > 0) {
            // 1 <= k <= n, so small and large cannot be all null.
            double smallDiff = small == null ? Double.MAX_VALUE : target - (double) small.val;
            double largeDiff = large == null ? Double.MAX_VALUE : (double) large.val - target;
            if (largeDiff < smallDiff) {
                res.add(large.val);
                large = next(ascTraverseSt);
            } else {
                res.add(small.val);
                small = prev(descTraverseSt);
            }
            k--;
        }
        return res;
    }

    private TreeNode peek(Deque<TreeNode> st) {
        return st.isEmpty() ? null : st.peek();
    }

    private Deque<TreeNode> initSt(TreeNode root, TreeNode target) {
        Deque<TreeNode> st = new ArrayDeque<>();
        if (target == null) {
            return st;
        }
        TreeNode cur = root;
        st.push(cur);
        while (cur != target) {
            if (cur.val < target.val) {
                cur = cur.right;
            } else {
                // cur.val > target.val
                cur = cur.left;
            }
            if (cur == null) {
                break;
            }
            st.push(cur);
        }
        return st;
    }

    // go to the next and return it.
    private TreeNode next(Deque<TreeNode> st) {
        if (st.isEmpty()) {
            return null;
        }
        TreeNode cur = st.peek();
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            return st.peek();
        }
        // cur.right == null, need to go up.
        cur = st.pop();
        while (!st.isEmpty() && st.peek().right == cur) {
            cur = st.pop();
        }
        return peek(st);
    }

    // go to the prev and return it.
    private TreeNode prev(Deque<TreeNode> st) {
        if (st.isEmpty()) {
            return null;
        }
        TreeNode cur = st.peek();
        if (cur.left != null) {
            cur = cur.left;
            while (cur != null) {
                st.push(cur);
                cur = cur.right;
            }
            return st.peek();
        }
        // cur.left == null, need to go up.
        cur = st.pop();
        while (!st.isEmpty() && st.peek().left == cur) {
            cur = st.pop();
        }
        return peek(st);
    }
}