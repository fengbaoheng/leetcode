/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
import java.util.*;

class Solution {
    // 十叉树的先序遍历
    // 下一层是根节点*10后依次+0~9得来的十个子节点
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();

        // 初始树节点
        for (int i = 9; i > 0; i--) {
            if (i <= n) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer d = stack.pop();
            result.add(d);

            // 动态生成下一层树节点并压栈
            final int base = d * 10;
            for (int i = 9; i >= 0; i--) {
                int value = base + i;
                if (value <= n) {
                    stack.push(value);
                }
            }
        }

        return result;
    }
}
// @lc code=end

