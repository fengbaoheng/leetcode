/*
 * @lc app=leetcode.cn id=118 lang=csharp
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (60.14%)
 * Total Accepted:    17.4K
 * Total Submissions: 28.8K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */
public class Solution
{
    public IList<IList<int>> Generate(int numRows)
    {
        var results = new List<IList<int>>();
        if (numRows <= 0) { return results; }

        // 递归初始条件
        results.Add(new List<int> { 1 });

        // 递归添加
        for (int i = 1; i < numRows; i++)
        {
            // 初始化, 并在头部+1
            var result = new List<int> { 1 };

            // 依次计算相邻的和
            var lastResult = results[i - 1];
            for (int j = 0; j < lastResult.Count - 1; j++)
            {
                result.Add(lastResult[j] + lastResult[j + 1]);
            }

            // 尾部+1
            result.Add(1);

            results.Add(result);
        }

        return results;
    }

}

