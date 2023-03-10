package TopKFrequentWords_692;

import java.util.*;
/**
 * Assume n is words.length.
 * Time Complexity: O(n * log(k))
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 85.55%
 */
public class Solution1 {
// Important constraints:
// 1. k is in the range [1, The number of unique words[i]].
public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word: words) {
        map.compute(word, (key,v)->v==null?1:v+1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>((x,y)->{
        int a = Integer.compare(map.get(x), map.get(y));
        return a == 0 ? y.compareTo(x) : a;
    });
    for (String s : map.keySet()) {
        pq.offer(s);
        if (pq.size() > k) {
            pq.poll();
        }
    }
    PriorityQueue<String> res = new PriorityQueue<>(k, (x,y)->{
        int a = Integer.compare(map.get(y), map.get(x));
        return a == 0 ? x.compareTo(y) : a;
    });
    for (String s : pq) {
        res.offer(s);
    }
    List<String> list = new ArrayList<>();
    while (!res.isEmpty()) {
        list.add(res.poll());
    }
    return list;
}
}