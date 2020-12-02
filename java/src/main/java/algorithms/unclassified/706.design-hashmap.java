/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
class MyHashMap {
    private static final int INIT_CAPACITY = 1024;
    private static final double factor = 0.75;
    private Node[] bucket;
    private int limit;
    private int size;


    public MyHashMap() {
        bucket = new Node[INIT_CAPACITY];
        limit = (int) (INIT_CAPACITY * factor);
    }


    public void put(int key, int value) {
        put(new Node(key, value));
    }

    private void put(Node node) {
        node.next = null;
        int index = node.key % bucket.length;
        Node head = bucket[index];

        while (head != null) {
            if (head.key == node.key) {
                // 更新节点值
                head.value = node.value;
                node = null;
                break;
            }
            head = head.next;
        }

        // 全都没有找到，插入新节点
        if (node != null) {
            node.next = bucket[index];
            bucket[index] = node;
        }

        size++;
        enlarge();
    }

    public int get(int key) {
        int index = key % bucket.length;
        Node head = bucket[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return -1;
    }


    public void remove(int key) {
        int index = key % bucket.length;
        Node head = bucket[index];
        if (head == null) {
            return;
        }

        if (head.key == key) {
            bucket[index] = head.next;
            size--;
        } else {
            while (head.next != null) {
                if (head.next.key == key) {
                    head.next = head.next.next;
                    size--;
                    break;
                }
                head = head.next;
            }
        }

    }

    /**
     * 扩大范围
     */
    private void enlarge() {
        if (size < limit) {
            return;
        }
        int N = bucket.length * 2;
        size = 0;
        limit = (int) (N * factor);

        // 旧桶数组迁移到新桶数组
        Node[] old = bucket;
        bucket = new Node[N];
        for (Node head : old) {
            while (head != null) {
                Node next = head.next;
                head.next = null;
                put(head);
                head = next;
            }
        }
    }

    // 封装为节点
    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

