#
# @lc app=leetcode.cn id=397 lang=python3
#
# [397] 整数替换
#
# https://leetcode-cn.com/problems/integer-replacement/description/
#
# algorithms
# Medium (29.48%)
# Total Accepted:    1.6K
# Total Submissions: 5.4K
# Testcase Example:  '8'
#
# 给定一个正整数 n，你可以做如下操作：
# 
# 1. 如果 n 是偶数，则用 n / 2替换 n。
# 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
# n 变为 1 所需的最小替换次数是多少？
# 
# 示例 1:
# 
# 
# 输入:
# 8
# 
# 输出:
# 3
# 
# 解释:
# 8 -> 4 -> 2 -> 1
# 
# 
# 示例 2:
# 
# 
# 输入:
# 7
# 
# 输出:
# 4
# 
# 解释:
# 7 -> 8 -> 4 -> 2 -> 1
# 或
# 7 -> 6 -> 3 -> 2 -> 1
# 
# 
#
class Solution:
    # 递归
    def integerReplacement(self, n: int) -> int:
        if n == 1:
            return 0
        
        if n % 2 == 0:
            return 1 + self.integerReplacement(n/2)
        else:
            return 1 + min(self.integerReplacement(n-1), self.integerReplacement(n+1))

