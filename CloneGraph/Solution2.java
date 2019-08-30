package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(|E| + |V|)
 * Space Complexity: O(|V|)
 * Runtime: 4ms
 * Rank: 86.61%
 */

class Solution2 {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        
        return dfs(node, map);
        
    }
    
    public Node dfs(Node node, Map<Node, Node> map){
        Node cNode = null;
        if(map.containsKey(node)){
            cNode = map.get(node);
            return cNode;
        } else{
            cNode = new Node(node.val, new ArrayList<Node>());
            map.put(node, cNode);
        }
        
        // explore the adjacent vertices
        for(Node neighbor: node.neighbors){
            cNode.neighbors.add(dfs(neighbor, map));
        }
        
        return cNode;
    }
}