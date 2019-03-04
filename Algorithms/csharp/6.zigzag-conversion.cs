/*
 * @lc app=leetcode.cn id=6 lang=csharp
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (39.47%)
 * Total Accepted:    22.3K
 * Total Submissions: 54.6K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 */
public class Solution
{
    public string Convert(string s, int numRows)
    {
        if (numRows <= 1) { return s; }

        var charList = new List<List<char>>();
        for (int j = 0; j < numRows; j++)
        {
            charList.Add(new List<char>());
        }

        int circle = 0;
        for (int i = 0; i < s.Length; i++)
        {
            if (circle == 0)
            {
                charList[circle].Add(s[i]);
            }
            else if (circle == numRows - 1)
            {
                // 最后一个数
                charList[circle].Add(s[i]);
                circle = -1;
                i = i + numRows - 2;
            }
            else
            {
                // 添加两个数
                charList[circle].Add(s[i]);

                int zIndex = i - circle + numRows + numRows - 2 - circle;
                if (zIndex < s.Length)
                {
                    charList[circle].Add(s[zIndex]);
                }
            }

            circle++;
        }

        for (int i = 1; i < numRows; i++)
        {
            charList[0].AddRange(charList[i]);
        }

        return string.Join("", charList[0]);
    }
}

