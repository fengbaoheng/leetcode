/*
 * @lc app=leetcode.cn id=1053 lang=java
 *
 * [1053] 交换一次的先前排列
 */

// @lc code=start
import java.util.*;

class Solution {
    private TreeMap<Integer, Integer> indexMap = new TreeMap<>();

    public int[] prevPermOpt1(int[] A) {
        // 逆序查找
        for (int i = A.length - 1; i >= 0; i--) {
            int num = A[i];

            int j = findSubNum(num);
            if (j != -1) {
                swap(A, i, j);
                break;
            }

            indexMap.put(num, i);
        }

        return A;
    }

    // 查找仅次于输入值的数字索引
    // 如果不存在则返回-1
    private int findSubNum(int num) {
        Map.Entry<Integer, Integer> lower = indexMap.lowerEntry(num);
        return lower == null ? -1 : lower.getValue();
    }

    // 交换
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
// @lc code=end

