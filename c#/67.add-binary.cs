/*
 * @lc app=leetcode.cn id=67 lang=csharp
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (45.61%)
 * Total Accepted:    16K
 * Total Submissions: 34.5K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
public class Solution
{
    private int CharToInt(char ch)
    {
        switch (ch)
        {
            case '0': return 0;
            case '1': return 1;
            default: return -1;
        }
    }

    private int AddChar(char a, char b, ref int carry)
    {
        int sum = CharToInt(a) + CharToInt(b) + carry;
        if (sum >= 2)
        {
            sum = sum % 2;
            carry = 1;
        }
        else
        {
            carry = 0;
        }

        return sum;
    }

    public string AddBinary(string a, string b)
    {
        List<int> listSum = new List<int>();
        string subString = "";
        int carry = 0;

        int lengthA = a.Length;
        int lengthB = b.Length;
        int lengthMin = Math.Min(lengthA, lengthB);

        for (int i = 0; i < lengthMin; i++)
        {
            int sum = AddChar(a[lengthA - 1 - i], b[lengthB - 1 - i], ref carry);
            listSum.Add(sum);
        }

        for (int i = 0; i < lengthA - lengthMin; i++)
        {
            int index = lengthA - lengthMin - i - 1;
            if (carry == 0)
            {
                subString = a.Substring(0, index + 1);
                break;
            }
            int sum = AddChar(a[index], '0', ref carry);
            listSum.Add(sum);
        }

        for (int i = 0; i < lengthB - lengthMin; i++)
        {
            int index = lengthB - lengthMin - i - 1;
            if (carry == 0)
            {
                subString = b.Substring(0, index + 1);
                break;
            }
            int sum = AddChar(b[index], '0', ref carry);
            listSum.Add(sum);
        }

        if (carry == 1) { listSum.Add(carry); }

        listSum.Reverse();
        string result = subString + string.Join("", listSum);

        return result;
    }
}
