/*
 * @lc app=leetcode.cn id=53 lang=csharp
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (41.52%)
 * Total Accepted:    35.5K
 * Total Submissions: 84.4K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
public class Solution
{
    public int MaxSubArray(int[] nums)
    {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            // sum若为正数,则继续累积有益
            // sum若为负,则前序累积毫无益处,直接丢弃重新求和
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = sum > max ? sum : max;
        }
        return max;
    }
}
