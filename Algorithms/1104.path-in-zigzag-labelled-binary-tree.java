/*
 * @lc app=leetcode.cn id=1104 lang=java
 *
 * [1104] 二叉树寻路
 */

// @lc code=start
import java.util.*;


class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new LinkedList<>();
        int layer = getLayer(label);

        if (layer == 0) {
            result.add(1);
            return result;
        }

        int parentLabel = getParentLabel(layer, label);
        result.addAll(pathInZigZagTree(parentLabel));
        result.add(label);

        return result;
    }

    // 依据节点值计算层数
    private int getLayer(int label) {
        if (label == 0) {
            return 0;
        }
        return (int) Math.floor(Math.log(label) / Math.log(2));
    }

    // 获取父节点值
    private int getParentLabel(int layer, int label) {
        int index = getIndex(layer, label);
        return getLabel(layer - 1, index / 2);
    }

    // 获取索引
    private int getIndex(int layer, int label) {
        int[] range = getRange(layer);
        int min = range[0];
        int max = range[1];
        return layer % 2 == 0 ? label - min : max - label;
    }

    // 依据索引获取值
    private int getLabel(int layer, int index) {
        int[] range = getRange(layer);
        int min = range[0];
        int max = range[1];
        return layer % 2 == 0 ? min + index : max - index;
    }

    // 计算某层数值的范围
    private int[] getRange(int layer) {
        return new int[]{(int) Math.pow(2, layer), (int) Math.pow(2, layer + 1) - 1};
    }
}
// @lc code=end

