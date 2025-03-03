package T.TimeBasedKeyValueStore_981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Constructor Time Complexity: O(1)
 * get() Time Complexity: O(logn)
 * put() Time Complexity: O(logn)
 * Space Complexity: O(n)
 * Runtime: 133ms
 * Rank: 64.60%
 */
class TimeMap1 {

    private final Map<String, TreeMap<Integer, String>> m = new HashMap<>();

    public TimeMap1() {

    }

    public void set(String key, String value, int timestamp) {
        if (!m.containsKey(key)) {
            m.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> tm = m.get(key);
        tm.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) {
            return "";
        }
        Map.Entry<Integer, String> e = m.get(key).floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }
}
