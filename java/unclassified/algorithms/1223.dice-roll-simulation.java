/*
 * @lc app=leetcode.cn id=1223 lang=java
 *
 * [1223] 掷骰子模拟
 */

// @lc code=start
import java.util.Arrays;


class Solution {
    private static final int M = (int) (1e9 + 7);

    public int dieSimulator(int n, int[] rollMax) {
        if (n == 1) {
            return 6;
        }

        Num[] nums = new Num[6];

        for (int i = 0; i < 6; i++) {
            Num num = new Num(rollMax[i]);
            num.count[0] = 1;
            nums[i] = num;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                nums[j].transfer(nums);
            }

            for (int j = 0; j < 6; j++) {
                nums[j].next();
            }
        }

        int count = 0;

        for (int i = 0; i < 6; i++) {
            Num num = nums[i];
            for (int j = 0; j < num.max; j++) {
                count += num.count[j];
                count %= M;
            }
        }

        return count;

    }

    private static class Num {
        private final int max;

        private int[] count;
        private int[] nextCount;

        public Num(int max) {
            this.max = max;
            this.count = new int[max];
            this.nextCount = new int[max];
        }

        // 转移到下个状态
        public void transfer(Num[] nums) {
            for (Num num : nums) {
                if (num == this) {
                    for (int i = 0; i < max - 1; i++) {
                        nextCount[i + 1] += count[i];
                        nextCount[i + 1] %= M;
                    }
                } else {
                    for (int i = 0; i < num.max; i++) {
                        nextCount[0] += num.count[i];
                        nextCount[0] %= M;
                    }
                }
            }
        }

        public void next() {
            int[] tmp = this.count;
            this.count = nextCount;
            this.nextCount = tmp;
            Arrays.fill(this.nextCount, 0);
        }
    }
}
// @lc code=end

