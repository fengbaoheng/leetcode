import java.util.*;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
 */

// @lc code=start
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // 依次记录节点值和索引
        Deque<Integer> indexStack = new LinkedList<>();
        Deque<Integer> valueStack = new LinkedList<>();

        List<Integer> results = new ArrayList<>();
        while (head != null) {
            int value = head.val;
            head = head.next;

            // 若栈内的值比当前值小，则记录至答案
            while (!valueStack.isEmpty() && valueStack.peek() < value) {
                valueStack.pop();
                int index = indexStack.pop();
                results.set(index, value);
            }

            indexStack.push(results.size());
            valueStack.push(value);

            results.add(0);
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
