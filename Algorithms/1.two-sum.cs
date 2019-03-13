/*
 * @lc app=leetcode.cn id=1 lang=csharp
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (43.82%)
 * Total Accepted:    220.9K
 * Total Submissions: 504.1K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */
public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        var sortedNums = (int[])nums.Clone();
        Array.Sort(sortedNums);

        int start = 0;
        int end = sortedNums.Length - 1;

        while (true)
        {
            int result = sortedNums[start] + sortedNums[end];
            if (result == target)
            {
                int? index0 = null;
                int? index1 = null;
                int i = 0;
                while (index0 is null || index1 is null)
                {
                    if (nums[i] == sortedNums[start] && index0 is null)
                    {
                        index0 = i;
                    }
                    else if (nums[i] == sortedNums[end] && index1 is null)
                    {
                        index1 = i;
                    }
                    i++;
                }
                return new int[] { (int)index0, (int)index1 };
            }
            else if (result < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
    }
}
