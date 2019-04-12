#
# @lc app=leetcode.cn id=228 lang=python3
#
# [228] 汇总区间
#
# https://leetcode-cn.com/problems/summary-ranges/description/
#
# algorithms
# Medium (46.58%)
# Total Accepted:    2K
# Total Submissions: 4.4K
# Testcase Example:  '[0,1,2,4,5,7]'
#
# 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
# 
# 示例 1:
# 
# 输入: [0,1,2,4,5,7]
# 输出: ["0->2","4->5","7"]
# 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
# 
# 示例 2:
# 
# 输入: [0,2,3,4,6,8,9]
# 输出: ["0","2->4","6","8->9"]
# 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
# 
#
from typing import List

class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        length = len(nums)

        # 边界
        if length == 0:
            return []
        elif length == 1:
            return [str(nums[0])]

        # 存储每一段边界[a,b]
        ranges = [[nums[0], nums[0]]]
        for num in nums:
            if num > ranges[-1][-1] + 1:
                # 新开一个边界[a,a]
                ranges.append([num,num])
            else:
                # 扩展右边界+1
                ranges[-1][-1] = num
        
        # 按格式输出
        results = []
        for r in ranges:
            a,b = r
            if a == b:
                results.append(str(a))
            else:
                results.append("{}->{}".format(a, b))
        
        return results




if __name__ == "__main__":
    print(Solution().summaryRanges([0,2,3,4,6,8,9]))

        

