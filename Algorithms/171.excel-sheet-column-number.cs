/*
 * @lc app=leetcode.cn id=171 lang=csharp
 *
 * [171] Excel表列序号
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (63.16%)
 * Total Accepted:    8.3K
 * Total Submissions: 13.2K
 * Testcase Example:  '"A"'
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 
 * 例如，
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: "A"
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: "AB"
 * 输出: 28
 * 
 * 
 * 示例 3:
 * 
 * 输入: "ZY"
 * 输出: 701
 * 
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * 
 */
public class Solution
{
    public int TitleToNumber(string s)
    {
        const int numChar = (int)'A' - 1;
        int count = s.Length;
        int result = 0;

        for (int i = 0; i < count; i++)
        {
            int base26 = (int)Math.Pow(26, i);
            int num = s[count - 1 - i] - numChar;
            result += num * base26;
        }

        return result;
    }
}
