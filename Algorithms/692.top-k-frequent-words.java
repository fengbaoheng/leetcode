import java.util.*;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        // 统计次数
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }

        // 排序规则
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diffCount = count.get(o1) - count.get(o2);
                return diffCount != 0 ? diffCount : o2.compareTo(o1);
            }
        };

        // 优先队列 最小堆
        PriorityQueue<String> heap = new PriorityQueue<>(k, comparator);

        // 插入队列 保持队列最多有k个数字
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 取出k个
        List<String> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }

        Collections.reverse(result);

        return result;
    }

}
// @lc code=end
