package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 克隆图
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * @Author snail
 */
public class LeetCode133 {

    // 记录已访问过的结点和新结点
    private HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // 结点已访问时 返回新结点
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // 将当前结点和新结点存入map
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        // 递归遍历当前结点 形成邻居结点列表返回
        for (Node neighbors : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbors));
        }
        return cloneNode;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
