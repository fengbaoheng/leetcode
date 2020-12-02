/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
import java.util.*;

/**
 * 单调栈
 */
class StockSpanner {
    Deque<Integer> priceStack = new ArrayDeque<>();
    Deque<Integer> spanStack = new ArrayDeque<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int span = 1;

        while (!priceStack.isEmpty() && priceStack.element() <= price) {
            priceStack.pop();
            span += spanStack.pop();
        }

        priceStack.push(price);
        spanStack.push(span);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

