package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Time Complexity: O(strs.length * average length of words in strs) or O(number of characters in strs)
 * Space Complexity: O(strs.length * 26)
 * Runtime: 30ms
 * Rank: 67.26%
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // == compares the address of two List.
        // equals compares the content of two List.
        // Two List with different content may have same hash code,
        // but two List with different hash code will never have same content.
        // List is a changeable object, it is not good to be a key.
        HashMap<List<Integer>, List<String>> map = new HashMap<>();
        List<String> temp = null;
        for (String s : strs) {
            // Use feature to record the occurrence times of each character. 
            List<Integer> feature = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
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
        System.out.println(a.equals(b));
        System.out.println(a == b);
        a.add(0, 1);
        b.add(0, 2);
        //System.out.println(a.get('a' - 97));
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}
