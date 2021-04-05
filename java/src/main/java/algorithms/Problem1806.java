package algorithms;

/**
 * 1806.还原排列的最少操作步数
 */
public class Problem1806 {

    class Solution {
        // 当任何一个数回到原始位置，则所有数都会回到原始位置，本题追踪1的变化
        public int reinitializePermutation(int n) {
            final int half = n / 2;

            // 数字1的初始位置
            int index = 1;

            int count = 0;

            do {
                count++;

                // 变换数字1的位置
                if (index < half) {
                    index *= 2;
                } else {
                    index = (index - half) * 2 + 1;
                }

                // 判断是否回到原始位置1
            } while (index != 1);

            return count;
        }
    }


}