package FindAllPossibleRecipesFromGivenSupplies_2115;

import java.util.*;

/**
 * Assume n is recipes.length.
 * Assume s is supplies.length.
 * Assume m is the number of entries in ingredients.
 * Time Complexity: O(n + s + m)
 * Space Complexity: O(n + s + m)
 * Runtime: 38ms
 * Rank: 93.16%
 */
public class Solution1 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        // n == recipes.length == ingredients.length
        Map<String, Integer> indeg = new HashMap<>();
        for (String recipe : recipes) {
            indeg.put(recipe, 0);
        }

        Set<String> can = new HashSet<>();
        Collections.addAll(can, supplies);

        Map<String, List<String>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (can.contains(recipes[i])) {
                continue;
            }
            List<String> ingredient = ingredients.get(i);
            for (String in : ingredient) {
                if (can.contains(in)) {
                    continue;
                }
                if (!g.containsKey(in)) {
                    g.put(in, new ArrayList<>());
                }
                g.get(in).add(recipes[i]);
                indeg.compute(recipes[i], (k, v) -> v + 1);
            }
        }

        Deque<String> q = new ArrayDeque<>();
        for (String recipe : recipes) {
            if (indeg.get(recipe) > 0) {
                continue;
            }
            q.offer(recipe);
            can.add(recipe);
        }
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (!g.containsKey(cur)) {
                continue;
            }
            for (String next : g.get(cur)) {
                indeg.compute(next, (k, v) -> v - 1);
                if (indeg.get(next) > 0) {
                    continue;
                }
                q.offer(next);
                can.add(next);
            }
        }
        List<String> res = new ArrayList<>();
        for (String recipe : recipes) {
            if (!can.contains(recipe)) {
                continue;
            }
            res.add(recipe);
        }
        return res;
    }
}