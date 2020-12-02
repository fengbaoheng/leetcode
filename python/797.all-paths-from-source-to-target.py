#
# @lc app=leetcode.cn id=797 lang=python3
#
# [797] 所有可能的路径
#
from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        length = len(graph)

        if length == 0:
            return []
        elif length == 1:
            return [[0]]

        cache = {}
        def find(source, target) -> List[List[int]]:
            if source == target:
                return [[target]]
            elif source in cache:
                return cache[source]

            result = []
            for joint in graph[source]:
                for route in find(joint, target):
                    result.append([source] + route)

            cache[source] = result
            return result

        return find(0, length - 1)

 


if __name__ == "__main__":
    Solution().allPathsSourceTarget([[1,2], [3], [3], []] )
