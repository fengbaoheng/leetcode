#
# @lc app=leetcode.cn id=390 lang=python3
#
# [390] 消除游戏
#
# https://leetcode-cn.com/problems/elimination-game/description/
#
# algorithms
# Medium (36.06%)
# Total Accepted:    710
# Total Submissions: 2K
# Testcase Example:  '9'
#
# 给定一个从1 到 n 排序的整数列表。
# 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
# 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
# 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
# 返回长度为 n 的列表中，最后剩下的数字。
# 
# 示例：
# 
# 
# 输入:
# n = 9,
# 1 2 3 4 5 6 7 8 9
# 2 4 6 8
# 2 6
# 6
# 
# 输出:
# 6
# 
#
class Solution:
    # 使用range()切片,只需改动start,end,step即可,不需创建list
    def lastRemaining(self, n: int) -> int:
        nums = range(1,n+1)
        is_left = True
        while len(nums) != 1:
            # 正向切
            if is_left:
                nums = nums[1::2]
            # 逆向切
            else:
                if len(nums) % 2==0:
                    nums = nums[::2]
                else:
                    nums = nums[1::2]
            # 转换方向
            is_left = not is_left
        return nums[0]