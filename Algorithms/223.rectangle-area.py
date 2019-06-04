#
# @lc app=leetcode.cn id=223 lang=python3
#
# [223] 矩形面积
#
class Solution:
    # 判断两个矩形间的位置关系
    def computeArea(
        self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int
    ) -> int:
        # 调整位置 使A B C D在左侧
        if A > E:
            A, B, C, D, E, F, G, H = E, F, G, H, A, B, C, D

        s1 = (C - A) * (D - B)
        s2 = (G - E) * (H - F)

        # 将图形看做被两个竖边切割
        if E >= C:  # 竖直不重叠
            return s1 + s2
        else:  # 竖直有重叠
            if (F >= D) or (H <= B):  # 水平无重叠
                return s1 + s2
            else:
                if G >= C:
                    # 三部分 AE EC CG
                    left = (E - A) * (D - B)
                    right = (G - C) * (H - F)
                    mid = (C - E) * (max(D, H) - min(B, F))
                    return left + right + mid
                else:
                    # 三部分 AE EG GC
                    left = (E - A) * (D - B)
                    right = (C - G) * (D - B)
                    mid = (G - E) * (max(D, H) - min(B, F))
                    return left + right + mid

