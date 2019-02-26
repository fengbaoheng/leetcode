/*
 * @lc app=leetcode.cn id=88 lang=csharp
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (41.97%)
 * Total Accepted:    26.3K
 * Total Submissions: 61.8K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */
public class Solution
{
    public void Merge(int[] nums1, int m, int[] nums2, int n)
    {
        var end = nums1.Length - 1;
        var end1 = m - 1;
        var end2 = n - 1;
        while (end1 >= 0 && end2 >= 0)
        {
            var num1 = nums1[end1];
            var num2 = nums2[end2];
            if (num1 >= num2)
            {
                nums1[end] = num1;
                end1 -= 1;
            }
            else
            {
                nums1[end] = num2;
                end2 -= 1;
            }

            end -= 1;
        }

        if (end1 < 0)
        {
            for (int i = 0; i <= end2; i++)
            {
                nums1[i] = nums2[i];
            }
        }
    }
}
