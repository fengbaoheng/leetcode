#
# @lc app=leetcode.cn id=150 lang=python3
#
# [150] 逆波兰表达式求值
#
# https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/description/
#
# algorithms
# Medium (43.24%)
# Total Accepted:    7K
# Total Submissions: 16.1K
# Testcase Example:  '["2","1","+","3","*"]'
#
# 根据逆波兰表示法，求表达式的值。
#
# 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
#
# 说明：
#
#
# 整数除法只保留整数部分。
# 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
#
#
# 示例 1：
#
# 输入: ["2", "1", "+", "3", "*"]
# 输出: 9
# 解释: ((2 + 1) * 3) = 9
#
#
# 示例 2：
#
# 输入: ["4", "13", "5", "/", "+"]
# 输出: 6
# 解释: (4 + (13 / 5)) = 6
#
#
# 示例 3：
#
# 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
# 输出: 22
# 解释:
# ⁠ ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
# = ((10 * (6 / (12 * -11))) + 17) + 5
# = ((10 * (6 / -132)) + 17) + 5
# = ((10 * 0) + 17) + 5
# = (0 + 17) + 5
# = 17 + 5
# = 22
#
#

from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # 题目输入保证了合法的表达式,否则需要验证
        
        # 定义运算符对应的函数
        function_dict = {
            "+": lambda x, y: x + y,
            "-": lambda x, y: x - y,
            "*": lambda x, y: x * y,
            "/": lambda x, y: int(x / y), # 只保留整数
        }

        stack = []
        for token in tokens:
            # 如果是运算符则出栈2位数进行运算后入栈
            if token in function_dict:
                # 先出栈的第二个操作数
                y, x = stack.pop(), stack.pop()
                result = function_dict[token](x, y)
                stack.append(result)
            # 普通数字直接入栈
            else:
                stack.append(int(token))

        return stack[0]


if __name__ == "__main__":
    print(Solution().evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))
