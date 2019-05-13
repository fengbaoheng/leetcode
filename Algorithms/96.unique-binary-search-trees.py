#
# @lc app=leetcode.cn id=96 lang=python3
#
# [96] 不同的二叉搜索树
#
class Solution:
    def __init__(self):
        self.cache = {}
        self.cache[0] = 1
        self.cache[1] = 1

    # 每个数字依次作为一个根节点
    # 根节点确定后左右子树的数字也确定
    # 计算左右子树分别有多少种情况做积
    def numTrees(self, n: int) -> int:    
        if n in self.cache:
            return self.cache[n]
        
        num = 0
        # 根节点左边i个数, 右边 n-1-i个数
        for i in range(n):
            num += self.numTrees(i) * self.numTrees(n-1-i)

        self.cache[n] = num
        return num



if __name__ == "__main__":
    print(Solution().numTrees(2))

