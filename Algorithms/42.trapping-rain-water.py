#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#
# https://leetcode-cn.com/problems/trapping-rain-water/description/
#
# algorithms
# Hard (42.39%)
# Total Accepted:    11.4K
# Total Submissions: 26.6K
# Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
#
# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
# 
# 
# 
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
# Marcos 贡献此图。
# 
# 示例:
# 
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
# 输出: 6
# 
#
from typing import List

class Solution:
    # 应该低柱子向高的柱子求差值累积水量
    # 双指针从收尾向内收, 最后集中到最高的柱子两侧
    def trap(self, height: List[int]) -> int:
        # 临界: 绝对无法接水的情况
        length = len(height)
        if length <= 2:
            return 0

        p = 0
        q = length -1
        p_cur = height[p]
        q_cur = height[q]

        total = 0
        while p < q:
            if height[p] <= height[q]:
                p +=1
                if height[p] > p_cur:
                    p_cur = height[p]
                else:
                    total += p_cur - height[p]
            else:
                q-=1
                if height[q] > q_cur:
                    q_cur = height[q]
                else:
                    total += q_cur - height[q]
        
        return total
        
if __name__ == "__main__":
    s = Solution()
    assert s.trap([0,0,0,0]) == 0
    assert s.trap([0,0,1,0,0]) == 0
    assert s.trap([0,1,0,1,0]) == 1
    assert s.trap([0,1,0,2,1,0,1,3,2,1,2,1]) == 6

