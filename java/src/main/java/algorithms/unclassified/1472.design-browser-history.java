/*
 * @lc app=leetcode.cn id=1472 lang=java
 *
 * [1472] 设计浏览器历史记录
 */

// @lc code=start
import java.util.*;

class BrowserHistory {

    private final Deque<String> backStack = new ArrayDeque<>();
    private final Deque<String> forwardStack = new ArrayDeque<>();

    public BrowserHistory(String homepage) {
        backStack.push(homepage);
    }

    public void visit(String url) {
        forwardStack.clear();
        backStack.push(url);
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (backStack.size() <= 1) {
                break;
            }
            forwardStack.push(backStack.pop());
        }
        return backStack.peek();
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (forwardStack.isEmpty()) {
                break;
            }
            backStack.push(forwardStack.pop());
        }
        return backStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

