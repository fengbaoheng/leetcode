#
# @lc app=leetcode.cn id=224 lang=python3
#
# [224] 基本计算器
#
class Solution:
    def calculate(self, s: str) -> int:
        if s is None:
            return 0

        length = len(s)
        if length == 0:
            return 0
        elif length == 1:
            return int(s)

        stack = []
        left_bracket_index = []

        # 去除括号
        for i in range(len(s)):
            c = s[i]
            if c == " ":
                continue
            elif c == "(":
                left_bracket_index.append(len(stack))
            elif c == ")":
                index = left_bracket_index.pop()
                expression = stack[index:]
                stack = stack[:index]
                stack.append(self.calculate_without_bracket(expression))
            else:
                stack.append(c)

        # 求解表达式
        return int(self.calculate_without_bracket(stack))

    # 纯表达式,没有括号,只有int型数字和"+", "-"
    def calculate_without_bracket(self, list) -> str:
        if not list:
            return "0"

        value = 0
        index = 0
        sign = 1
        for i in range(len(list)):
            c = list[i]
            if c == "+" or c == "-":
                value += sign * int("".join(list[index:i]))
                sign = 1 if c == "+" else -1
                index = i + 1
        
        value += sign * int("".join(list[index:]))
        
        return str(value)


if __name__ == "__main__":
    solution = Solution()
    exp = "(1+(40+51+2)-3)+(6+8)+()+(1)"
    print("{} = {}".format(exp, solution.calculate(exp)))
