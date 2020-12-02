#
# @lc app=leetcode.cn id=295 lang=python3
#
# [295] 数据流的中位数
#
from heapq import *

# 使用最小堆构造最大堆
class MaxHeap:
    def __init__(self):
        self.heap = []

    def push(self, num) -> None:
        heappush(self.heap, -num)

    def get_max(self) -> int:
        return -self.heap[0]

    def replace(self, num) -> None:
        heapreplace(self.heap, -num)


# 维护最大最小堆, 分别存储中位数两边的数
# 保证两个堆数目相等或差1即可
# heapq为最小堆,因此使用负数构造最大堆
class MedianFinder:
    def __init__(self):
        self.left_max_heap = MaxHeap()
        self.right_min_heap = []
        self.count = 0

    def addNum(self, num: int) -> None:
        if self.count % 2 == 0:
            heappush(self.right_min_heap, num)
        else:
            self.left_max_heap.push(num)

        self.count += 1

        if self.count < 3:
            return

        # 左右平衡
        left_num = self.left_max()
        right_num = self.right_min()
        if left_num > right_num:
            # 交换边界数字
            heapreplace(self.right_min_heap, left_num)
            self.left_max_heap.replace(right_num)

    def findMedian(self) -> float:
        if self.count == 0:
            return 0
        # 右侧最小堆数目大于等于左侧堆数目 差值不超过1
        elif self.count % 2 == 0:
            return (self.left_max() + self.right_min()) / 2
        else:
            return self.right_min()

    # 左侧最大值, heapq库仅提供最小堆
    def left_max(self) -> int:
        return self.left_max_heap.get_max()

    # 右侧最小值
    def right_min(self) -> int:
        return self.right_min_heap[0]

