/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start
import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        Deque<Integer> stack = new LinkedList<>();
        for (Integer num : splitNum(n)) {
            stack.push(num);
        }

        // 从后向前寻找第一个值下降的数字
        int[] backValues = new int[10];
        while (stack.size() > 1) {
            int cur = stack.pop();
            int pre = stack.element();

            backValues[cur]++;

            // 即将递减
            if (pre < cur) {
                // 寻找已经搜索过的比pre更大的值
                int biggerValue = pre + 1;
                while (biggerValue <= 9) {
                    if (backValues[biggerValue] > 0) {
                        break;
                    }
                    biggerValue++;
                }

                // 将pre替换为更大的值
                stack.pop();
                backValues[pre]++;
                stack.push(biggerValue);
                backValues[biggerValue]--;

                // 栈内剩余数字取出
                List<Integer> arr = new LinkedList<>();
                while (!stack.isEmpty()) {
                    arr.add(stack.pop());
                }
                Collections.reverse(arr);

                // 将此时的backValues组合为一个最小数
                for (int num = 0; num <= 9; num++) {
                    int count = backValues[num];
                    for (int i = 0; i < count; i++) {
                        arr.add(num);
                    }
                }

                // 拼接
                long result = 0;
                for (int val : arr) {
                    result = result * 10 + val;
                }
                return result <= Integer.MAX_VALUE ? (int) result : -1;
            }
        }

        return -1;
    }

    private List<Integer> splitNum(int num) {
        LinkedList<Integer> list = new LinkedList<>();

        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }

        Collections.reverse(list);
        return list;
    }
}
// @lc code=end
