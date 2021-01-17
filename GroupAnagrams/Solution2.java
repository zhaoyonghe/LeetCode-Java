package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Time Complexity: O(strs.length * max length of words in strs * log(max length of words in strs))
 * Space Complexity: O(strs.length * average length of words in strs) or O(number of characters in strs)
 * Runtime: 16ms
 * Rank: 99.74%
 */
public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String feature = String.valueOf(temp);
            if (map.containsKey(feature)) {
                result.get(map.get(feature)).add(s);
            } else {
                map.put(feature, index);
                index++;
                List<String> tempx = new ArrayList<>();
                tempx.add(s);
                result.add(tempx);
            }
        }
        return result;
    }

}
