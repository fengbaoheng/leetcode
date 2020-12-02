/*
 * @lc app=leetcode.cn id=12 lang=csharp
 *
 * [12] 整数转罗马数字
 *
 * https://leetcode-cn.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (57.82%)
 * Total Accepted:    16.5K
 * Total Submissions: 28.6K
 * Testcase Example:  '3'
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V +
 * II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数
 * 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 
 * 
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 
 * 示例 1:
 * 
 * 输入: 3
 * 输出: "III"
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "IV"
 * 
 * 示例 3:
 * 
 * 输入: 9
 * 输出: "IX"
 * 
 * 示例 4:
 * 
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 
 * 
 * 示例 5:
 * 
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 */
public class Solution
{
    public string IntToRoman(int num)
    {
        var BaseCharDict = new Dictionary<int, char[]>
        {
            {0, new char[]{ 'I', 'V', 'X'} },
            {1, new char[]{ 'X', 'L', 'C'} },
            {2, new char[]{ 'C', 'D', 'M'} },
            {3, new char[]{ 'M'} },
        };

        // 拆分整数为单个数字, 和基数位
        int pow10 = 0;
        int singleNum;
        char[] charArr;
        var stringBuilder = new StringBuilder();

        while (num != 0)
        {
            singleNum = num % 10;
            charArr = BaseCharDict[pow10];
            var str = "";
            switch (singleNum)
            {
                case 0: break;
                case 1:
                case 2:
                case 3:
                    str = new string(charArr[0], singleNum);
                    break;
                case 4:
                    str = charArr[0].ToString() + charArr[1].ToString();
                    break;
                case 5:
                    str = charArr[1].ToString();
                    break;
                case 6:
                case 7:
                case 8:
                    str = charArr[1].ToString() + new string(charArr[0], singleNum - 5);
                    break;
                case 9:
                    str = charArr[0].ToString() + charArr[2].ToString();
                    break;
            }

            stringBuilder.Insert(0, str);
            num = num / 10;
            pow10++;
        }

        return stringBuilder.ToString();
    }
}

