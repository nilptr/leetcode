/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<Integer, UndirectedGraphNode> map = new TreeMap<>();

        return cloneGraph(node, map);
    }
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
                                          Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode copy;

        if (map.containsKey(node.label)) {
            // 已被创建 -> 已经遍历 / 正在遍历
            copy = map.get(node.label);
        } else {
            copy = new UndirectedGraphNode(node.label);
            // 先放入 map 防止环回
            map.put(node.label, copy);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                copy.neighbors.add(cloneGraph(neighbor, map));
            }
        }
        return copy;
    }
}