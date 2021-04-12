package algorithms;

/**
 * 1822.数组元素积的符号
 */
public class Problem1822 {

    static class Solution {
        public int arraySign(int[] nums) {
            int neg = 0;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                } else if (num < 0) {
                    neg++;
                }
            }

            return neg % 2 == 0 ? 1 : -1;
        }
    }
}