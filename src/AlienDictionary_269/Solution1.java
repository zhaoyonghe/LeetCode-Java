package AlienDictionary_269;

import java.util.*;
/**
 * Assume n is the number of characters in words.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 97.31%
 */
public class Solution1 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> g = new HashMap<>();
        if (!build(words, 0, words.length - 1, 0, g)) {
            return "";
        }
        // Top sort.
        int[] map = new int[128];
        Arrays.fill(map, -1);
        for (String w:words){
            for (char c:w.toCharArray()){
                map[c]=0;
            }
        }
        for (Set<Character> set : g.values()) {
            for (char c: set) {
                map[c]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();
        for (char i = 0; i < 128; i++) {
            if (map[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            if (!g.containsKey(cur)) {
                continue;
            }
            for (char next : g.get(cur)) {
                map[next]--;
                if (map[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (char i = 0; i < 128; i++) {
            if (map[i] > 0) {
                return "";
            }
        }
        return sb.toString();
    }

    private boolean build(String[] words, int s, int e, int j, Map<Character, Set<Character>> g) {
        if (s >= e) {
            return true;
        }
        // All string in words[s:e+1] has the same prefix [0:j].
        int initi = s;
        while (initi <= e && words[initi].length() == j) {
            initi++;
        }
        for (int i = initi; i <= e; i++) {
            String w = words[i];
            if (w.length() == j) {
                return false;
            }
            char init = words[initi].charAt(j);
            if (init == w.charAt(j)) {
                continue;
            }
            if (!g.containsKey(init)) {
                g.put(init, new HashSet());
            }
            g.get(init).add(w.charAt(j));
            if (!build(words, initi, i - 1, j + 1, g)) {
                return false;
            }
            initi = i;
        }
        return build(words, initi, e, j + 1, g);
    }
}
