/*
 * @lc app=leetcode.cn id=119 lang=csharp
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (54.14%)
 * Total Accepted:    10.7K
 * Total Submissions: 19.7K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
public class Solution
{
    public IList<int> GetRow(int rowIndex)
    {
        // 传入的是索引
        var result = new List<int> { 1 };

        if (rowIndex == 0) { return result; }

        // 套用公式进行计算
        // i从1开始, 因为公式需要用到result[i-1]
        long num = 1;
        for (int i = 1; i < rowIndex + 1; i++)
        {
            num = num * (rowIndex - i + 1) / i;
            result.Add((int)num);
        }

        return result;
    }
}

