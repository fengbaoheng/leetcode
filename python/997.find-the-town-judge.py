#
# @lc app=leetcode.cn id=997 lang=python3
#
# [997] 找到小镇的法官
#
from typing import List, Dict, Set


class Solution:
    # 每个人看成节点 维护两个集合, 一个是他信任的, 一个是他被信任的
    # 法官的信任集合为0, 被信任集合个数为N-1

    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N <= 0:
            return -1
        elif N == 1:
            return 1

        trust_dict: Dict[int, Set[int]] = {}
        be_trusted_dict: Dict[int, Set[int]] = {}

        for p, tp in trust:
            if p not in trust_dict:
                trust_dict[p] = set([])
            if tp not in be_trusted_dict:
                be_trusted_dict[tp] = set([])

            trust_dict[p].add(tp)
            be_trusted_dict[tp].add(p)
        
        judge = -1
        for i in range(1, N+1):
            if i not in trust_dict and i in be_trusted_dict and len(be_trusted_dict[i]) == N-1:
                judge = i
                break

        return judge