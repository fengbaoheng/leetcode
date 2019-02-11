/*
 * @lc app=leetcode.cn id=70 lang=csharp
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (43.30%)
 * Total Accepted:    27.5K
 * Total Submissions: 63.4K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */
public class Solution
{
    // 记录已求出的结果
    private Dictionary<int, int> solutionTable = new Dictionary<int, int>() {
            {1, 1 },
            {2, 2 },
            {3, 3 },
        };
    public int ClimbStairs(int n)
    {
        if (!this.solutionTable.ContainsKey(n))
        {
            // 方案1: 先爬1步再爬剩下n-1步 
            // 方案2: 先爬2步再爬剩下n-2步 
            this.solutionTable[n] = ClimbStairs(n - 1) + ClimbStairs(n - 2);
        }

        return this.solutionTable[n];
    }
}
