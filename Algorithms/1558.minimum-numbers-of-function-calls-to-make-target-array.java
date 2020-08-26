/*
 * @lc app=leetcode.cn id=1558 lang=java
 *
 * [1558] 得到目标数组的最少函数调用次数
 */

// @lc code=start
import java.util.Collections;
import java.util.LinkedList;


class Solution {
    /**
     * 每次操作可以：
     * 1. 让数组中的某个索引值+1
     * 2. 数组中所有数字*2
     * 问需要几次操作可以把全零的数组变为nums
     * 逆向思维，从nums出发，把所有数都变为0
     */
    public int minOperations(int[] nums) {
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int num : nums) {
            list.addLast(num);
        }
        Collections.sort(list);

        // 折半次数
        int halfCount = 0;
        while (!list.isEmpty()) {
            int num = list.removeFirst();

            // 按前面累积的折半次数计算
            for (int i = 0; i < halfCount; i++) {
                // 奇数减一则自减变为偶数，再折半
                if (num % 2 == 1) {
                    count++;
                }

                num /= 2;
            }


            // 继续处理num
            while (num != 0) {
                if (num % 2 == 1) {
                    num--;
                    count++;
                } else {
                    num /= 2;
                    count++;
                    halfCount++;
                }
            }
        }

        return count;
    }
}
// @lc code=end

