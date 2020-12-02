#
# @lc app=leetcode.cn id=406 lang=python3
#
# [406] 根据身高重建队列
#
from typing import List


class Solution:
    # 按身高h排序逆序排序, 同身高者按k值顺序排序
    # 按排序后的k值作为索引插入即可
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        sorted_people = sorted(people, key=lambda p: (p[0], -p[1]), reverse=True)
        queue = []
        for p in sorted_people:
            index = p[1]
            queue.insert(index, p)
        
        return queue


if __name__ == "__main__":
    result = Solution().reconstructQueue([[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]])
    print(result)
