/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class MapSum {
    private Node root;

    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        root.insert(key, 0, val);
    }

    public int sum(String prefix) {
        if (prefix.isEmpty()) {
            return root.sum();
        }

        Node node = root.find(prefix, 0);
        return node == null ? 0 : node.sum();
    }

    private static class Node {
        int value = 0;
        Map<Character, Node> children = new HashMap<>(26);

        void insert(String target, int index, int value) {
            char ch = target.charAt(index);
            children.putIfAbsent(ch, new Node());
            Node child = children.get(ch);

            if (index == target.length() - 1) {
                child.value = value;
            } else {
                child.insert(target, index + 1, value);
            }
        }

        Node find(String target, int index) {
            char ch = target.charAt(index);
            Node child = children.get(ch);
            if (child == null || index == target.length() - 1) {
                return child;
            }

            return child.find(target, index + 1);
        }

        int sum() {
            return this.value + children.values().stream().mapToInt(Node::sum).sum();
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

