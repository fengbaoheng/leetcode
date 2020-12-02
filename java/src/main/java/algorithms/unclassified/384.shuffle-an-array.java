/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
import java.util.Random;

class Solution {
    private final Random random = new Random();
    private final int[] nums;
    private final int n;

    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] result = nums.clone();

        for (int i = n - 1; i > 0; i--) {
            // j取值范围 [0, i]
            int j = random.nextInt(i + 1);

            // swap
            int tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

