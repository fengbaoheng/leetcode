/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的K对数字
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();

        // 边界情况
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        Pointer.nums1 = nums1;
        Pointer.nums2 = nums2;

        // 优先队列，每次找出最小的和
        Queue<Pointer> queue = new PriorityQueue<>(nums1.length, Comparator.comparingInt(Pointer::getSum));
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new Pointer(i));
        }

        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                break;
            }

            Pointer pointer = queue.poll();
            result.add(pointer.getPair());

            // 移动指针，重新排序
            if (pointer.next()) {
                queue.offer(pointer);
            }
        }

        return result;
    }


}

class Pointer {
    public static int[] nums1, nums2;

    // 两个记录两个指针的位置
    // 其中p值固定，每次滑动q的值并重新记录和值
    private int p, q, sum;

    public Pointer(int p) {
        this.p = p;
        updateSum();
    }

    private void updateSum() {
        this.sum = nums1[p] + nums2[q];
    }


    // 滑动q的指针，若能滑动则返回true
    public boolean next() {
        q++;
        if (q >= nums2.length) {
            return false;
        }
        updateSum();
        return true;
    }

    public int getSum() {
        return sum;
    }

    public List<Integer> getPair() {
        LinkedList<Integer> pair = new LinkedList<>();
        pair.add(nums1[p]);
        pair.add(nums2[q]);
        return pair;
    }
}
// @lc code=end

