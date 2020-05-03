/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        // 记录非递减序列的最小值与修改标记
        int min = Integer.MIN_VALUE;
        boolean canModified = true;

        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int next = nums[i + 1];
            
            // 依旧符合非递减
            if (cur <= next) {
                min = cur;
                continue;
            }

            // 不符合非递减，但是已经修改过1次了
            // 直接失败
            if (!canModified) {
                return false;
            }
            
            // 尝试修改
            canModified = false;
            
            // 修改可以将当前值降低也可将下一值提高
            // 当前值压低到min还不符合条件的话，再提高下一值
            if (min > next) {
                nums[i + 1] = cur;
            }
        }

        return true;
    }
}
// @lc code=end

