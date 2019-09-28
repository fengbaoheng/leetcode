
/*
 * @lc app=leetcode.cn id=1042 lang=java
 *
 * [1042] 不邻接植花
 */
import java.util.*;

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        // 记录所有花园
        Map<Integer, Garden> gardens = new HashMap<>();

        // 创建花园 从0下标开始
        for (int i = 0; i < N; i++) {
            gardens.put(i, new Garden(i));
        }

        // 建立花园联系
        for (int[] path : paths) {
            int o = path[0] - 1;
            int d = path[1] - 1;
            gardens.get(o).addNeighbor(gardens.get(d));
        }

        int[] result = new int[N];

        // 由邻居最多的花园开始种花
        gardens.values().stream().sorted(Comparator.comparing(Garden::getNeighborCount))
                .forEach(g -> result[g.id] = g.plant());

        return result;
    }
}

class Garden {
    int id;
    Set<Garden> neighbors = new HashSet<>();
    int flower;

    public Garden(int id) {
        this.id = id;
    }

    // 以邻居数量排序
    int getNeighborCount() {
        return neighbors.size();
    }

    void addNeighbor(Garden neighbor) {
        neighbors.add(neighbor);

        // 双向添加邻居
        if (!neighbor.neighbors.contains(this)) {
            neighbor.addNeighbor(this);
        }
    }

    // 种花, 返回花的编号
    int plant() {
        // 所有的花种类
        int[] flowers = new int[5];
        for (Garden neighbor : neighbors) {
            flowers[neighbor.flower] = 1;
        }

        // 找到邻居中没有种过的花
        for (int i = 1; i <= 4; i++) {
            if (flowers[i] == 0) {
                flower = i;
                break;
            }
        }

        return flower;
    }
}