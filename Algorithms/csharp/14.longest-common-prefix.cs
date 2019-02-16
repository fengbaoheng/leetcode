/*
 * @lc app=leetcode.cn id=14 lang=csharp
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.39%)
 * Total Accepted:    47.3K
 * Total Submissions: 150.2K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
public class Solution
{
    public string LongestCommonPrefix(string[] strs)
    {
        if (strs.Length == 0)
        {
            return "";
        }

        List<char> prefixList = new List<char>();

        //  循环次数 = 最短的字符长度
        int count = strs.Min(str => str.Length);
        for (int i = 0; i < count; i++)
        {
            char commonPrefix = strs[0][i];
            if (strs.All(str => str[i] == commonPrefix))
            {
                prefixList.Add(commonPrefix);
            }
            else
            {
                break;
            }
        }

        return new string(prefixList.ToArray());
    }
}
