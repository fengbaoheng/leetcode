/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    // 使用负数代表该位置处的数字已经出现过
    // 当遇到两次负数时意味着重复出现
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                result.add(num);
            }
        }

        return result;
    }
}

