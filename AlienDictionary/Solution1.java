package AlienDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution1 {
	public String alienOrder(String[] words) {
		HashMap<Character, HashSet<Character>> graph = new HashMap<Character, HashSet<Character>>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				graph.putIfAbsent(words[i].charAt(j), new HashSet<Character>());
			}
		}

		buildGraph(graph, words);
		// System.out.println(graph);

		HashMap<Character, Integer> status = new HashMap<>();
		for (Character c : graph.keySet()) {
			status.put(c, 0);
		}

		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Character, HashSet<Character>> entry : graph.entrySet()) {
			if (status.get(entry.getKey()) == 0) {
				if (!dfs(graph, entry.getKey(), status, sb)) {
					return "";
				}
			}
		}

		return sb.reverse().toString();
	}

	public boolean dfs(HashMap<Character, HashSet<Character>> graph, char node, HashMap<Character, Integer> status,
			StringBuilder sb) {
		status.put(node, 1);
		for (Character nei : graph.get(node)) {
			if (status.get(nei) == 1) {
				return false;
			}
			if (status.get(nei) == 0) {
				if (!dfs(graph, nei, status, sb)) {
					return false;
				}
			}
		}
		status.put(node, 2);
		sb.append(node);
		return true;
	}

	public void buildGraph(HashMap<Character, HashSet<Character>> graph, String[] words) {
		// System.out.println("--------------");
		// System.out.println(graph);
		// System.out.println(Arrays.toString(words));

		int n = words.length;
		if (n <= 1) {
			return;
		}

		for (int i = 0; i + 1 < n; i++) {
			char a = words[i].charAt(0);
			char b = words[i + 1].charAt(0);

			if (a != b) {
				// add a->b into the graph
				graph.get(a).add(b);
			}
		}

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(26);
		for (int i = 0; i < 26; i++) {
			list.add(new ArrayList<String>());
		}

		for (int i = 0; i < n; i++) {
			if (words[i].length() > 1) {
				list.get(words[i].charAt(0) - 'a').add(words[i].substring(1, words[i].length()));
			}
		}

		for (int i = 0; i < 26; i++) {
			if (list.get(i).size() > 1) {
				buildGraph(graph, list.get(i).toArray(new String[list.get(i).size()]));
			}
		}
	}
}
