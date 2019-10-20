/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
import java.util.*;


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        // 使用单调栈记录值和索引
        Deque<Integer> stackValue = new LinkedList<>();
        Deque<Integer> stackIndex = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            // 当前值较之前大时, 依次出栈并循环比较
            while (!stackValue.isEmpty() && value > stackValue.peek()) {
                stackValue.pop();
                result[stackIndex.pop()] = value;
            }

            stackValue.push(value);
            stackIndex.push(i);
        }

        // 最大数组之后未确定的值
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value <= stackValue.peek()) {
                continue;
            }

            while (value > stackValue.peek()) {
                stackValue.pop();
                int index = stackIndex.pop();
                result[index] = value;
            }
        }

        // 最后剩下的即数组中所有最大元素
        for (Integer index : stackIndex) {
            result[index] = -1;
        }

        return result;
    }
}
// @lc code=end

