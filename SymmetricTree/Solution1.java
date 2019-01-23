package SymmetricTree;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		List<Integer> list = new ArrayList<>();
		inOrderTravelsal(root, list);
		System.out.println(list);
		int size = list.size();
		for (int i = 0; i < size / 2; i++) {
			if (list.get(i) != list.get(size - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public void inOrderTravelsal(TreeNode root, List<Integer> list) {
		if (root == null) {
			//list.add(null);
			return;
		}
		inOrderTravelsal(root.left, list);
		list.add(root.val);
		inOrderTravelsal(root.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		System.out.println(list);
	}

}
