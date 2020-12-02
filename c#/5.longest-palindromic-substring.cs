/*
 * @lc app=leetcode.cn id=5 lang=csharp
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (23.83%)
 * Total Accepted:    39.3K
 * Total Submissions: 159.7K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
public class Solution
{
    private List<char> ExtendPalindrome(int leftIndex, int rightIndex, ref string s)
    {
        var result = new List<char>();
        var length = s.Length;

        while (leftIndex >= 0 && rightIndex < length)
        {
            var left = s[leftIndex];
            var right = s[rightIndex];
            if (left != right)
            {
                break;
            }

            result.Insert(0, left);
            result.Add(right);

            leftIndex--;
            rightIndex++;
        }

        return result;
    }


    public string LongestPalindrome(string s)
    {
        if (s.Length <= 1) { return s; }

        var longest = new List<char>();
        for (int i = 0; i < s.Length; i++)
        {
            var evenStr = ExtendPalindrome(i, i + 1, ref s);

            var oddStr = ExtendPalindrome(i - 1, i + 1, ref s);
            oddStr.Insert(oddStr.Count / 2, s[i]);

            if (evenStr.Count > longest.Count)
            {
                longest = evenStr;
            }

            if (oddStr.Count > longest.Count)
            {
                longest = oddStr;
            }
        }

        return string.Join("", longest);
    }
}

