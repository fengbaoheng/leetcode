/*
 * @lc app=leetcode.cn id=38 lang=csharp
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (47.43%)
 * Total Accepted:    20.4K
 * Total Submissions: 42.5K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
public class Solution
{
    public int CountRepeat(List<int> list, int startIndex)
    {
        int length = list.Count;
        if (startIndex < 0 || startIndex >= length) { return -1; }

        int repeatValue = list[startIndex];
        int repeat = 0;
        for (int i = startIndex; i < length; i++)
        {
            if (list[i] == repeatValue)
            {
                repeat++;
            }
            else
            {
                break;
            }
        }
        return repeat;
    }

    public string CountAndSay(int n)
    {
        int count = 1;
        var preList = new List<int> { 1 };
        var curList = new List<int>();

        while (count < n)
        {
            int index = 0;
            while (index < preList.Count)
            {
                int repeat = this.CountRepeat(preList, index);
                curList.Add(repeat);
                curList.Add(preList[index]);

                index += repeat;
            }

            preList = curList;
            curList = new List<int>();

            count++;
        }

        return string.Join("", preList);
    }
}
