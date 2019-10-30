/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
import java.util.*;

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    // 克隆单个节点, 并返回
    private Node clone(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node cloned = new Node();
        cloned.val = node.val;

        // 先加入map中, 防止在拷贝邻居节点时重复创建本节点
        map.put(node, cloned);

        cloned.neighbors = new ArrayList<>();
        for (Node n : node.neighbors) {
            cloned.neighbors.add(clone(n));
        }

        return cloned;
    }
}
// @lc code=end

