/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {

    private int capacity = 1024;
    private double factor = 0.75;
    private double threshold = (int) (capacity * factor);
    private int size = 0;

    private Entry[] table = new Entry[1024];

    public MyHashSet() {

    }

    public void add(int key) {
        int i = key % table.length;
        Entry entry = table[i];

        // 不存在链表，则直接创建链表头节点
        if (entry == null) {
            table[i] = new Entry(key);
            expand();
            return;
        }

        // 搜索链表，查看是否已经添加过
        while (entry != null) {
            if (entry.key == key) {
                // 已经添加过则不需重复添加
                return;
            }
            entry = entry.next;
        }

        // 头插法插入节点
        entry = new Entry(key);
        entry.next = table[i];
        table[i] = entry;

        expand();
    }

    public void remove(int key) {
        int i = key % table.length;
        Entry entry = table[i];

        // 不存在节点
        if (entry == null) {
            return;
        }

        // 待删除节点是头节点
        if (entry.key == key) {
            table[i] = entry.next;
            return;
        }

        // 删除链表节点
        Entry pre = entry;
        entry = entry.next;

        while (entry != null) {
            if (entry.key == key) {
                pre.next = entry.next;
            }
            pre = entry;
            entry = entry.next;
        }
    }

    public boolean contains(int key) {
        int i = key % table.length;
        Entry entry = table[i];

        while (entry != null) {
            if (key == entry.key) {
                return true;
            }
            entry = entry.next;
        }

        return false;
    }


    private void expand() {
        size++;
        if (size > threshold) {
            rehash();
        }
    }

    private void rehash() {
        Entry[] newTable = new Entry[capacity * 2];

        Entry entry, next;
        for (int i = 0, j; i < table.length; i++) {
            entry = table[i];

            while (entry != null) {
                next = entry.next;

                j = entry.key % newTable.length;
                entry.next = newTable[j];
                newTable[j] = entry;

                entry = next;
            }

        }


        capacity *= 2;
        threshold = (int) (capacity * threshold);
        table = newTable;
    }

    private static class Entry {
        private final int key;
        private Entry next;

        public Entry(int key) {
            this.key = key;
        }
    }
}
// @lc code=end

