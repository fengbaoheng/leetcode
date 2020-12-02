/*
 * @lc app=leetcode.cn id=1381 lang=java
 *
 * [1381] 设计一个支持增量操作的栈
 */

// @lc code=start
class CustomStack {

    int[] stack;
    int maxSize;
    int size;
    int[] increase;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;

        this.stack = new int[maxSize];
        this.increase = new int[maxSize];
    }

    public void push(int x) {
        if (size >= maxSize) {
            return;
        }

        stack[size] = x;
        increase[size] = 0;
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }

        size--;

        int value = stack[size];
        value += increase[size];

        if (size > 0) {
            increase[size - 1] += increase[size];
        }

        return value;
    }

    public void increment(int k, int val) {
        if (size == 0) {
            return;
        }

        if (size < k) {
            k = size;
        }

        increase[k - 1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such: CustomStack
 * obj = new CustomStack(maxSize); obj.push(x); int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end
