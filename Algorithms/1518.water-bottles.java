/*
 * @lc app=leetcode.cn id=1518 lang=java
 *
 * [1518] 换酒问题
 */

// @lc code=start
class Solution {
    private int drunk, remain, empty, numExchange;

    public int numWaterBottles(int numBottles, int numExchange) {
        drunk = empty = 0;
        remain = numBottles;
        this.numExchange = numExchange;

        while (remain != 0) {
            drink();
            exchange();
        }

        return drunk;
    }

    private void drink() {
        drunk += remain;
        empty += remain;
        remain = 0;
    }

    private void exchange() {
        remain += empty / numExchange;
        empty %= numExchange;
    }
}
// @lc code=end

