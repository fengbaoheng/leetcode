/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findIndex(arr, x);

        LinkedList<Integer> result = new LinkedList<>();
        result.add(arr[index]);

        // 向两侧扩展拿到k个数字
        int left = index - 1, right = index + 1;
        for (int i = 1; i < k; i++) {
            int dLeft = left >= 0 ? x - arr[left] : Integer.MAX_VALUE;
            int dRight = right < arr.length ? arr[right] - x : Integer.MAX_VALUE;

            if (dLeft <= dRight) {
                result.addFirst(arr[left]);
                left--;
            } else {
                result.addLast(arr[right]);
                right++;
            }
        }

        return result;
    }

    // 二分法寻找最接近x的索引
    private int findIndex(int[] arr, int x) {
        if (x <= arr[0]) {
            return 0;
        }

        final int len = arr.length;
        if (x >= arr[len - 1]) {
            return len - 1;
        }

        int left = 0, right = len - 1;
        while (true) {
            int mid = left + (right - left) / 2;
            int midNum = arr[mid];

            if (midNum == x) {
                return mid;
            } else if (midNum < x) {
                if (left == mid) {
                    break;
                }
                left = mid;
            } else {
                if (right == mid) {
                    break;
                }
                right = mid;
            }
        }

        return x - arr[left] <= arr[right] - x ? left : right;
    }
}
// @lc code=end

