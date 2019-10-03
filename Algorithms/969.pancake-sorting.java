/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */

// @lc code=start
import java.util.*;

class Solution {
    // 找到最大值的位置i
    // 翻转i: 最大值到头部
    // 翻转n: 最大值到末尾
    // 依次递归
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>(A.length * 2);
        Deque<Integer> deque = new LinkedList<>();

        for (int num : A) {
            deque.addLast(num);
        }

        pancakeSort(deque, result);

        return result;
    }

    public void pancakeSort(Deque<Integer> deque, List<Integer> result) {
        int n = deque.size();
        if (n <= 1) {
            return;
        }

        if (deque.peekLast() == n) {
            // 最大值就在尾部, 不用反转
            deque.pollLast();
        } else if (deque.peekFirst() == n) {
            // 最大值在头部, 只用反转1次
            deque.pollFirst();
            reverse(deque);
            result.add(n);
        } else {
            List<Integer> tmp = new ArrayList<>(n);
            int i = 1, num = deque.pollFirst();
            while (num != n) {
                tmp.add(num);
                num = deque.pollFirst();
                i++;
            }

            reverse(deque);
            deque.addAll(tmp);

            result.add(i);
            result.add(n);
        }

        pancakeSort(deque, result);
    }

    // 反转队列
    private void reverse(Deque<Integer> deque) {
        Collections.reverse((List<Integer>) deque);
    }
}
// @lc code=end
