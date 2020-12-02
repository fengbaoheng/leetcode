/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */

// @lc code=start
import java.util.*;

class FreqStack {
    // 存放每个数字对应的频率
    private Map<Integer, Integer> frequencyMap = new HashMap<>();

    // 存放每个频率下对应的所有数字
    // 可能有多个数字出现频率相同，为了区分先后使用栈存储
    private Map<Integer, Deque<Integer>> frequencyNumMap = new HashMap<>();

    private int maxFrequency;

    public FreqStack() {

    }

    public void push(int x) {
        // x的频率自增
        int xFrequency = frequencyMap.merge(x, 1, Integer::sum);

        // 为该频率对应的栈中添加x
        frequencyNumMap.computeIfAbsent(xFrequency, f -> new ArrayDeque<>()).push(x);

        maxFrequency = Math.max(maxFrequency, xFrequency);
    }

    public int pop() {
        // 当前最大频率下有哪些数字
        Deque<Integer> stack = frequencyNumMap.get(maxFrequency);

        // 返回最后入栈的数字作为结果
        int num = stack.pop();

        frequencyMap.merge(num, -1, Integer::sum);

        // 当前频率下的所有数字都已经出栈
        if (stack.isEmpty()) {
            // 频率降低
            frequencyNumMap.remove(maxFrequency);
            maxFrequency--;
        }

        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

