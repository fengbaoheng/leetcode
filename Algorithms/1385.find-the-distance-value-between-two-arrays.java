import java.util.*;

/*
 * @lc app=leetcode.cn id=1385 lang=java
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : arr2) {
            treeSet.add(num);
        }

        int result = 0;

        for (int num : arr1) {
            if(treeSet.contains(num)){
                continue;
            }

            Integer lower = treeSet.lower(num);
            Integer higher = treeSet.higher(num);
            if ((lower != null && (num - lower) <= d) || (higher != null && (higher - num) <= d)) {
                continue;
            }

            result++;
        }

        return result;
    }
}
// @lc code=end
