/*
 * @lc app=leetcode.cn id=168 lang=csharp
 *
 * [168] Excel表列名称
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (29.21%)
 * Total Accepted:    4.6K
 * Total Submissions: 15.9K
 * Testcase Example:  '1'
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如，
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "A"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 28
 * 输出: "AB"
 * 
 * 
 * 示例 3:
 * 
 * 输入: 701
 * 输出: "ZY"
 * 
 * 
 */
public class Solution
{
    public string ConvertToTitle(int n)
    {
        const string table = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 1-26
        var result = new List<char>();

        while (n != 0)
        {
            var remainder = n % 26;
            n = n / 26;
            if (remainder == 0)
            {
                result.Add('Z');
                n -= 1;
            }
            else
            {
                result.Add(table[remainder]);
            }
        }

        result.Reverse();

        return new string(result.ToArray());
    }
}
