/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    private final Node HEAD, TAIL;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        HEAD = new Node(-1);
        TAIL = new Node(-1);

        HEAD.next = TAIL;
        TAIL.prev = HEAD;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = findNode(index);
        return node != null ? node.value : -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        size++;

        Node node = new Node(val);
        node.next = HEAD.next;
        node.prev = HEAD;

        HEAD.next.prev = node;
        HEAD.next = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        size++;

        Node node = new Node(val);
        node.next = TAIL;
        node.prev = TAIL.prev;

        TAIL.prev.next = node;
        TAIL.prev = node;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else if (index < size) {
            Node node = findNode(index);
            Node newNode = new Node(val);

            newNode.next = node;
            newNode.prev = node.prev;

            node.prev.next = newNode;
            node.prev = newNode;

            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node node = findNode(index);

        if (node == null) {
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;

        size--;
    }

    private Node findNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node node = HEAD.next;
        while (index != 0) {
            node = node.next;
            index--;
        }

        return node;
    }

    private static class Node {
        private final int value;
        private Node next, prev;

        public Node(int value) {
            this.value = value;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

