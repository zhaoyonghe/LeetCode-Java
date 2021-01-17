package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Time Complexity: O(|E| + |V|)
 * Space Complexity: O(|E| + |V|)
 * Runtime: 7ms
 * Rank: 9.70%
 */
public class Solution1 {
    public Node cloneGraph(Node node) {
        // key: node
        // value: the index of this node in the unfolded array 
        HashMap<Node, Integer> map = new HashMap<>();

        int i = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        // unfold the graph to an array, O(|E|)
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (!map.containsKey(tempNode)) {
                map.put(tempNode, i);
                i += 1;
                for (Node n : tempNode.neighbors) {
                    if (!map.containsKey(n)) {
                        queue.offer(n);
                    }
                }
            }
        }

        // O(|V|)
        Node[] nodes = new Node[map.size()];
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            Node tempNode = new Node(entry.getKey().val, new ArrayList<Node>());
            nodes[entry.getValue()] = tempNode;
        }

        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            for (Node n : entry.getKey().neighbors) {
                nodes[entry.getValue()].neighbors.add(nodes[map.get(n)]);
            }
        }

        return nodes[0];
    }
}
