package GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			int[] tempfeature = new int[26];
			for (int i = 0; i < s.length(); i++) {
				tempfeature[s.charAt(i) - 97] += 1;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tempfeature.length; i++) {
				sb.append(String.valueOf(tempfeature[i]));
				sb.append('#');
			}
			String feature = sb.toString();
			if (!map.containsKey(feature)) {
				map.put(feature, new LinkedList<>());
			}
			map.get(feature).add(s);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
