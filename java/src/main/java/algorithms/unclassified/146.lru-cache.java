/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;

    private int count;
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        visit(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        // 不存在，则直接插入
        if (node == null) {
            // 已满则删除尾节点
            deleteIfFull();
            insertHead(key, value);
            return;
        }

        // 已存在，更新值并将节点提升至头节点
        node.value = value;
        visit(node);
    }

    private void visit(Node node) {
        delete(node);
        insertHead(node);
    }

    private void deleteIfFull() {
        if (count < capacity) {
            return;
        }
        count--;

        Node end = tail.pre;
        map.remove(end.key);

        end.pre.next = tail;
        tail.pre = end.pre;

        end.pre = null;
        end.next = null;
    }

    private void insertHead(int key, int value) {
        Node node = new Node(key, value);
        insertHead(node);

        map.put(key, node);
        count++;
    }

    private void insertHead(Node node) {
        Node start = head.next;

        node.pre = head;
        node.next = start;

        head.next = node;
        start.pre = node;
    }

    private void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private static class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

