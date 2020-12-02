#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#
# https://leetcode-cn.com/problems/generate-parentheses/description/
#
# algorithms
# Medium (68.81%)
# Total Accepted:    16.3K
# Total Submissions: 23.6K
# Testcase Example:  '3'
#
# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
# 
# 例如，给出 n = 3，生成结果为：
# 
# [
# ⁠ "((()))",
# ⁠ "(()())",
# ⁠ "(())()",
# ⁠ "()(())",
# ⁠ "()()()"
# ]
# 
# 
#
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n < 1:
            return []

        result = [["", 0, n]]
        for i in range(n*2):
            rr = []
            for r in result:
                cur = r[1]
                left = r[2]
                # 只能减不能加
                if left != 0:
                    rr.append([r[0]+"(", cur+1, left-1])
                
                # 只能加不能减
                if cur != 0:
                    rr.append([r[0]+")", cur-1, left])
                
                result = rr

        return [r[0] for r in result]
        


        

