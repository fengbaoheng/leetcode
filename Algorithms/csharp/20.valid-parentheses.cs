/*
 * @lc app=leetcode.cn id=20 lang=csharp
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.88%)
 * Total Accepted:    43K
 * Total Submissions: 119K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
public class Solution
{
    private bool IsRightBracket(char ch)
    {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private bool IsMatchedLeft(ref Stack<char> stack, char ch)
    {
        if (stack.Count == 0) // 空栈
        {
            return false;
        }

        char topCh = stack.Peek();
        switch (ch)
        {
            case '}': return topCh == '{';
            case ']': return topCh == '[';
            case ')': return topCh == '(';
            default: return false;
        }
    }

    public bool IsValid(string s)
    {
        if (s.Length == 0) return true;
        if (s.Length == 1) return false;

        Stack<char> stack = new Stack<char>();
        foreach (char ch in s)
        {
            if (IsRightBracket(ch)) // 右侧括号
            {
                if (IsMatchedLeft(ref stack, ch)) // 检测是否匹配左侧括号
                {
                    stack.Pop();
                }
                else
                {
                    return false;
                }
            }
            else // 左侧括号,直接压栈
            {
                stack.Push(ch);
            }
        }

        return stack.Count == 0;
    }
}

