#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#
# https://leetcode-cn.com/problems/jump-game/description/
#
# algorithms
# Medium (33.65%)
# Total Accepted:    12.2K
# Total Submissions: 36K
# Testcase Example:  '[2,3,1,1,4]'
#
# 给定一个非负整数数组，你最初位于数组的第一个位置。
# 
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
# 
# 判断你是否能够到达最后一个位置。
# 
# 示例 1:
# 
# 输入: [2,3,1,1,4]
# 输出: true
# 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
# 
# 
# 示例 2:
# 
# 输入: [3,2,1,0,4]
# 输出: false
# 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
# 
# 
#
class Solution:
    # 1. 分而治之(时间长)
    # 能否跳到第n个可拆分为
    # 能否跳到第n-1个且nums[n-1]>=1
    # 能否跳到第n-2个且nums[n-2]>=2
    # 能否跳到第i个且nums[i]>=n-i
    # 能否跳到第1个且nums[1]>=n-1

    # 2. 打靶
    # 从每个位置依次向前计算打靶的最远位置，直到能够超出数组界限
    def canJump(self, nums) -> bool:
        length = len(nums)

        if length == 0:
            return True

        maxIndex = 0 # 最远打靶距离
        for i in range(length):
            # 循环超过了最远打靶距离，终止
            if i > maxIndex:
                return False

            curMaxIndex = nums[i] + i
            if curMaxIndex > maxIndex:
                maxIndex = curMaxIndex

                # 判断是否能打到最终点
                if maxIndex >= length - 1:
                    return True
        return False

