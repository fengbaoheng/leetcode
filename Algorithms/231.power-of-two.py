#
# @lc app=leetcode.cn id=231 lang=python3
#
# [231] 2的幂
#
# https://leetcode-cn.com/problems/power-of-two/description/
#
# algorithms
# Easy (44.25%)
# Total Accepted:    13.6K
# Total Submissions: 30.5K
# Testcase Example:  '1'
#
# 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
# 
# 示例 1:
# 
# 输入: 1
# 输出: true
# 解释: 2^0 = 1
# 
# 示例 2:
# 
# 输入: 16
# 输出: true
# 解释: 2^4 = 16
# 
# 示例 3:
# 
# 输入: 218
# 输出: false
# 
#
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        
        # 统计2进制数中1出现的次数是否仅为1
        bin_str = bin(n)[2:]
        return bin_str.count('1') == 1
        

