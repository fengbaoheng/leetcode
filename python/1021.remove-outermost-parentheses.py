#
# @lc app=leetcode.cn id=1021 lang=python3
#
# [1021] 删除最外层的括号
#
class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        length = len(S)

        if length == 0:
            return ""

        stack = []  # 记录左括号索引
        result = ""

        for i in range(length):
            s = S[i]

            if s == "(":
                stack.append(i)
            elif s == ")":
                rest = len(stack)
                if rest == 1:
                    left_i = stack.pop()
                    result += S[left_i+1:i]
                else:
                    stack.pop()

        return result


if __name__ == "__main__":
    solution = Solution()

    cases = {
        "": "",
        "()": "",
        "()()": "",
        "()(())": "()",
        "(()())(())(()(()))": "()()()()(())",
        "(()())(())": "()()()",
    }

    for raw, result in cases.items():
        assert solution.removeOuterParentheses(raw) == result
