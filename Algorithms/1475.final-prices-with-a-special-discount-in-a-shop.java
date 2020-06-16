/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = Arrays.copyOfRange(prices, 0, n);

        Deque<Integer> stack = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++) {
            int price = prices[i];

            while (stack.size() > 0) {
                int preIndex = stack.peek();
                int prePrice = prices[preIndex];
                if (price <= prePrice) {
                    stack.pop();
                    result[preIndex] -= price;
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        return result;
    }
}
// @lc code=end

