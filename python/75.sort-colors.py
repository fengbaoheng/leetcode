#
# @lc app=leetcode.cn id=75 lang=python3
#
# [75] 颜色分类
#

from typing import List


class Solution:
    # 三指针, p,r,q
    # p记录0与1的分界线
    # q记录1与2的分界线
    # r在p,q间遍历直到r>=q
    def sortColors(self, nums: List[int]) -> None:
        try:
            length = len(nums)

            p, r, q = 0, 0, length - 1
            while r <= q:
                if nums[p] == 0:
                    p += 1
                    r = max(r, p)
                elif nums[q] == 2:
                    q -= 1
                else:
                    if nums[r] == 0:
                        nums[p], nums[r] = nums[r], nums[p]
                        p += 1
                    elif nums[r] == 2:
                        nums[r], nums[q] = nums[q], nums[r]
                        q -= 1
                    else:
                        r += 1
        except:
            return


if __name__ == "__main__":
    c = [0]
    Solution().sortColors(c)
    print(c)
