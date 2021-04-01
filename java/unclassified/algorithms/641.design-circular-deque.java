/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    private int remain, k;
    private final Node HEAD, TAIL;

    public MyCircularDeque(int k) {
        this.k = k;
        this.remain = k;
        this.HEAD = new Node(-1);
        this.TAIL = new Node(-1);
        this.HEAD.next = TAIL;
        this.TAIL.prev = HEAD;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        remain--;

        Node node = new Node(value);

        node.next = HEAD.next;
        node.prev = HEAD;

        HEAD.next = node;
        node.next.prev = node;

        return true;
    }


    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        remain--;

        Node node = new Node(value);

        node.next = TAIL;
        node.prev = TAIL.prev;

        TAIL.prev = node;
        node.prev.next = node;

        return true;
    }


    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        remain++;

        Node toDelete = HEAD.next;

        HEAD.next = toDelete.next;
        toDelete.next.prev = HEAD;

        toDelete.prev = null;
        toDelete.next = null;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        remain++;

        Node toDelete = TAIL.prev;

        TAIL.prev = toDelete.prev;
        toDelete.prev.next = TAIL;

        toDelete.next = null;
        toDelete.prev = null;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return HEAD.next.value;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return TAIL.prev.value;
    }

    public boolean isEmpty() {
        return this.remain == k;
    }

    public boolean isFull() {
        return this.remain == 0;
    }

    private static class Node {
        private final int value;
        private Node prev, next;

        public Node(int value) {
            this.value = value;
        }
    }
}
// @lc code=end

