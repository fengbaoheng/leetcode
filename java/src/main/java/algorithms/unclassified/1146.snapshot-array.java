
/*
 * @lc app=leetcode.cn id=1146 lang=java
 *
 * [1146] 快照数组
 */

import java.util.HashMap;

class SnapshotArray {
    private int snapCount = 0;

    // 使用Map维护索引处各代的数值
    private HashMap<Integer, Integer>[] snapStore;

    public SnapshotArray(int length) {
        snapStore = new HashMap[length];
    }

    // 直接复制当代数值
    public void set(int index, int val) {
        if (snapStore[index] == null) {
            snapStore[index] = new HashMap<>();
        }

        snapStore[index].put(snapCount, val);
    }

    // 代数向前推进
    public int snap() {
        return snapCount++;
    }

    public int get(int index, int snap_id) {
        if (snapStore[index] == null) {
            return 0;
        }

        HashMap<Integer, Integer> map = snapStore[index];

        // 若查询代数不存在,说明该代数值与上代保持一致
        while (!map.containsKey(snap_id)) {
            if (snap_id == 0) {
                return 0;
            }
            snap_id -= 1;
        }

        return snapStore[index].getOrDefault(snap_id, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length); obj.set(index,val); int
 * param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */
