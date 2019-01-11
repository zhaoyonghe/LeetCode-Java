package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
/**
 * Time Complexity: O(strs.length * max length of words in strs)
 * Space Complexity: O(strs.length * max length of words in strs)
 * Runtime: 30ms
 * Rank: 67.26%
 */
public class Solution1 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<List<Integer>, List<String>> map = new HashMap<>();
		List<String> temp = null;
		for (String s : strs) {
			List<Integer> feature = new ArrayList<>(26);
			for(int i = 0; i < 26; i++) {
				feature.add(0);
			}
			for (int i = 0; i < s.length(); i++) {
				int count = feature.get(s.charAt(i) - 97);
				count += 1;
				feature.set(s.charAt(i) - 97, count);
			}
			if (map.containsKey(feature)) {
				temp = map.get(feature);
				temp.add(s);
				map.put(feature, temp);
			} else {
				temp = new LinkedList<String>();
				temp.add(s);
				map.put(feature, temp);
			}
		}
		List<List<String>> result = new LinkedList<>();
		for (List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>(26);
		ArrayList<Integer> b = new ArrayList<>(26);
		System.out.println(a.get('a' - 97));
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(a.hashCode());
	}

}
