package GroupAnagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Time Complexity: O(strs.length * max length of words in strs * log(max length of words in strs))
 * Space Complexity: O(strs.length * average length of words in strs) or O(number of characters in strs)
 * Runtime: 5ms
 * Rank: 99.23%
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String feature = new String(temp);
            if (map.containsKey(feature)) {
                res.get(map.get(feature)).add(s);
            } else {
                map.put(feature, res.size());
                res.add(new ArrayList<String>() {{
                    add(s);
                }});
            }
        }
        return res;
    }
}
