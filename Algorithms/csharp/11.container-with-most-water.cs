/*
 * @lc app=leetcode.cn id=11 lang=csharp
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (51.05%)
 * Total Accepted:    30.4K
 * Total Submissions: 57.2K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */
public class Solution
{
    public int MaxArea(int[] height)
    {
        // 面积取决于两个值, 高度和间距
        // 两条边的高度尽可能高, 且间距尽可能拉开
        // O(n2)的方法是,对所有可能的情况进行遍历,最后求最大的值
        // O(n): 双指针, 由最远的距离逐步向内逼近
        var length = height.Length;
        var maxArea = 0;
        var startIndex = 0;
        var endIndex = length - 1;
        while (startIndex != endIndex)
        {
            var left = height[startIndex];
            var right = height[endIndex];
            var h = Math.Min(left, right);
            var d = endIndex - startIndex;
            var area = h * d;
            if (area > maxArea)
            {
                maxArea = area;
            }

            if (right > left)
            {
                startIndex++;
            }
            else
            {
                endIndex--;
            }
        }
        return maxArea;
    }
}

