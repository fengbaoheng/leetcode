/*
 * @lc app=leetcode.cn id=58 lang=csharp
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (28.28%)
 * Total Accepted:    16.9K
 * Total Submissions: 58.9K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */
public class Solution
{
    public int LengthOfLastWord(string s)
    {
        int index = -1;
        for (int i = s.Length - 1; i >= 0; i--)
        {
            if (s[i] != ' ' && index == -1)
            {
                index = i;
            }

            if (s[i] == ' ' && index != -1)
            {
                return index - i;
            }
        }

        return index + 1;
    }
}
