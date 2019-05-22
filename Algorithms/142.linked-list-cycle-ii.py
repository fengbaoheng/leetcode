#
# @lc app=leetcode.cn id=142 lang=python
#
# [142] 环形链表 II
#
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    # 先通过快慢指针判断是否有环
    # 如果有则再计算环的数目count
    # 通过相距count远的快慢指针获得环的首个节点
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None
        
        if head.next is None:
            return None
        
        fast = head.next
        slow = head

        # 快指针一次2步, 慢指针一次1步
        while (fast is not None) and (fast != slow):
            slow = slow.next
            fast = fast.next
            if fast is not None:
                fast = fast.next
            
        
        # 快指针走到了链表尾部, 没有环
        if fast is None:
            return None

        # 若快慢指针相遇则说明都在存在环,且二者都在环中
        # 让slow不动, fast每次走1步
        # 当fast==slow时,fast走的步数就是环的长度count
        count = 1
        fast = fast.next
        while fast != slow:
            fast = fast.next
            count += 1


        # 再从头开始,前后双指针间隔count
        slow = head
        fast = head
        while count > 0:
            fast = fast.next
            count -= 1
        
        # 快慢指针同步走,再次碰面时就在入口处
        while fast!=slow:
            fast = fast.next
            slow = slow.next
        
        return slow


        
if __name__ == "__main__":
    nodes = [ListNode(3),ListNode(2),ListNode(0),ListNode(-4)]

    nodes[0].next = nodes[1]
    nodes[1].next = nodes[2]
    nodes[2].next = nodes[3]
    nodes[3].next = nodes[1]

    n = Solution().detectCycle(nodes[0])
    print(n.val)