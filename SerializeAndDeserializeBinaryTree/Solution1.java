package SerializeAndDeserializeBinaryTree;
/**
 * Serialize Time Complexity: O(n)
 * Deserialize Time Complexity: O(n)
 * Serialize Space Complexity: O(n)
 * Deserialize Space Complexity: O(n)
 * Runtime: 87ms
 * Rank: 7.94%
 */
public class Solution1 {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		String pre = sb.toString();
		sb = new StringBuilder();
		inOrder(root, sb);
		String in = sb.toString();
		return pre + "- " + in;
	}

	public void preOrder(TreeNode node, StringBuilder sb) {
		if (node == null)
			return;
		sb.append(String.valueOf(node.val)).append(",").append(node.hashCode()).append(" ");
		preOrder(node.left, sb);
		preOrder(node.right, sb);
	}

	public void inOrder(TreeNode node, StringBuilder sb) {
		if (node == null)
			return;
		inOrder(node.left, sb);
		sb.append(String.valueOf(node.val)).append(",").append(node.hashCode()).append(" ");
		inOrder(node.right, sb);
	}

	int ri = 0;

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("null")) {
			return null;
		}
		String[] ss = data.split(" - ");
		String[] spre = ss[0].split(" ");
		String[] sin = ss[1].split(" ");
		int[] pre = new int[spre.length];
		String[] hpre = new String[spre.length];
		int[] in = new int[sin.length];
		String[] hin = new String[sin.length];
		for (int i = 0; i < spre.length; i++) {
			String[] tem = spre[i].split(",");
			pre[i] = Integer.valueOf(tem[0]);
			hpre[i] = tem[1];
			String[] temp = sin[i].split(",");
			in[i] = Integer.valueOf(temp[0]);
			hin[i] = temp[1];
		}
		ri = 0;
		return treeBuilder(pre, hpre, in, hin, 0, sin.length - 1);
	}

	public TreeNode treeBuilder(int[] pre, String[] hpre, int[] in, String[] hin, int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(pre[ri]);
		int nextRootIndex = findIndexInInOrderByHashCode(hpre[ri], hin, start, end);
		ri++;
		root.left = treeBuilder(pre, hpre, in, hin, start, nextRootIndex - 1);
		root.right = treeBuilder(pre, hpre, in, hin, nextRootIndex + 1, end);
		return root;
	}

	public int findIndexInInOrderByHashCode(String hashCode, String[] hin, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (hashCode.equals(hin[i])) {
				return i;
			}
		}
		return -1;
	}
}
