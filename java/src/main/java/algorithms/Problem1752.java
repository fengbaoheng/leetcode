package algorithms;

/**
 * 1752.检查数组是否经排序和轮转得到
 */
public class Problem1752 {
    static class Solution {
        public boolean check(int[] nums) {
            final int n = nums.length;
            // 第一段升序
            final int[] range1 = getAscRange(nums, 0);
            final int end1 = range1[1];

            // 是否整体有序
            if (end1 == n - 1) {
                return true;
            }

            // 第二段升序
            final int[] range2 = getAscRange(nums, end1 + 1);
            final int end2 = range2[1];

            // 无法分为两段
            if (end2 != n - 1) {
                return false;
            }

            // 判断是否可以轮转
            return nums[n - 1] <= nums[0];
        }

        // 获取升序范围
        private int[] getAscRange(int[] nums, int start) {
            final int n = nums.length;

            int[] range = {start, start};
            int preNum = nums[start];
            for (int i = start + 1; i < n; i++) {
                int num = nums[i];
                if (num >= preNum) {
                    preNum = num;
                    range[1] = i;
                } else {
                    break;
                }
            }
            return range;
        }
    }
}