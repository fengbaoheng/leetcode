#
# @lc app=leetcode.cn id=165 lang=python3
#
# [165] 比较版本号
#
from typing import List


class Solution:
    # 难点在于边界条件要考虑严谨
    def compareVersion(self, version1: str, version2: str) -> int:
        # 转换为数字格式
        v1 = self.split_version(version1)
        v2 = self.split_version(version2)
        v1_len = len(v1)
        v2_len = len(v2)

        length = min(v1_len, v2_len)
        for i in range(length):
            if v1[i] < v2[i]:
                return -1
            elif v1[i] > v2[i]:
                return 1

        # 二者前缀均相同, 比较剩余的部分
        v1_rest = sum(v1[length:])
        v2_rest = sum(v2[length:])
        if v1_rest < v2_rest:
            return -1
        elif v1_rest > v2_rest:
            return 1
        else:
            return 0

    def split_version(self, version: str) -> List[int]:
        return list(map(int, version.split(".")))


if __name__ == "__main__":
    s = Solution()
    assert s.compareVersion("1.0", "1.00.00") == 0
    assert s.compareVersion("1.2", "1.2.1") == -1
    assert s.compareVersion("1.002.1.0", "1.2.1") == 0
