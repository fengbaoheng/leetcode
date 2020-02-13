/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第K大元素
 */

// @lc code=start
import java.util.*;

class KthLargest {

    // 使用优先队列代替最小堆
    private PriorityQueue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        
        // 保持队列长度不超过k
        // 此时队列尾部就是最大值, 队列头部就是第K大值
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

