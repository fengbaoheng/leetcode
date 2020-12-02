#
# @lc app=leetcode.cn id=671 lang=python3
#
# [671] 二叉树中第二小的节点
#
# https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
#
# algorithms
# Easy (45.60%)
# Total Accepted:    2.5K
# Total Submissions: 5.5K
# Testcase Example:  '[2,2,5,null,null,5,7]'
#
# 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或
# 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
#
# 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
#
# 示例 1:
#
#
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 2   5
# ⁠    / \
# ⁠   5   7
#
# 输出: 5
# 说明: 最小的值是 2 ，第二小的值是 5 。
#
#
# 示例 2:
#
#
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 2   2
#
# 输出: -1
# 说明: 最小的值是 2, 但是不存在第二小的值。
#
#
#

# 解法1: 返回所有节点值,排序取第二个
# class Solution:
#     def findSecondMinimumValue(self, root: TreeNode) -> int:

#         min_num = self.find_min(root.left) + self.find_min(root.right) + [root.val]
#         min_num = list(set(min_num)) # 去除重复

#         if len(min_num) < 2:
#             return -1

#         min_num.sort()
#         if min_num[0] != min_num[1]:
#             return min_num[1]
#         else:
#             return -1

#     # 找到节点最大前两个节点值
#     def find_min(self, root: TreeNode)->List[int]:
#         if root is None:
#             return []

#         min_num = [root.val] + self.find_min(root.left) + self.find_min(root.right)
#         min_num = list(set(min_num)) # 去除重复

#         if len(min_num) <= 2:
#             return min_num
#         else:
#             min_num.sort()
#             return min_num[:2]


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 解法3: 已知左右子树值即为该树的最小值,再计算其次小值进行比较
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        # 根节点值为整棵树的最小值
        min_val = [root.val]

        if root.left is not None:
            # 如果和根节点相等,再去找子树是否有更大的值(子树的次小值)
            if root.val == root.left.val:
                left_min = self.findSecondMinimumValue(root.left)
                if left_min != -1 and left_min != root.val:
                    min_val.append(left_min)
            # 如果和根节点不等,则次小值必定在根节点和两个子树节点之间,不需再向下找
            else:
                min_val.append(root.left.val)

        # 与左子树对称
        if root.right is not None:
            if root.val == root.right.val:
                right_min = self.findSecondMinimumValue(root.right)
                if right_min != -1 and right_min != root.val:
                    min_val.append(right_min)
            else:
                min_val.append(root.right.val)

        # min_val一定不重复
        if len(min_val) < 2:
            return -1
        else:
            min_val.sort()
            return min_val[1]

