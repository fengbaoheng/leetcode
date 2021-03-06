/*
 * @lc app=leetcode.cn id=35 lang=csharp
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.12%)
 * Total Accepted:    28.3K
 * Total Submissions: 66.6K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */
public class Solution
{
    public int SearchInsert(int[] nums, int target)
    {
        int length = nums.Length;
        if (length == 0) { return 0; }
        else if (target <= nums[0]) { return 0; }
        else if (target > nums[length - 1]) { return length; }

        int min = 0;
        int max = length - 1;

        while (true)
        {
            if (target == nums[min])
            {
                return min;
            }
            else if (target == nums[max])
            {
                return max;
            }
            else if (max - min == 1)
            {
                return max;
            }

            int mid = (min + max) / 2;
            if (target == nums[mid])
            {
                return mid;
            }
            else if (target < nums[mid])
            {
                max = mid;
            }
            else
            {
                min = mid;
            }
        }
    }
}
