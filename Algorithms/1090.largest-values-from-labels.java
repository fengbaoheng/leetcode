/*
 * @lc app=leetcode.cn id=1090 lang=java
 *
 * [1090] 受标签影响的最大值
 */

// @lc code=start
import java.util.*;


class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;

        // 由大到小排序
        List<Item> items = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            items.add(new Item(values[i], labels[i]));
        }
        Collections.sort(items);

        // 记录Label使用情况
        Map<Integer, Integer> labelUsedMap = new HashMap<>();

        int result = 0;
        for (int i = 0; i < n && num_wanted > 0; i++) {
            Item item = items.get(i);

            int labelUsed = labelUsedMap.getOrDefault(item.label, 0);
            if (labelUsed >= use_limit) {
                continue;
            }

            num_wanted--;
            result += item.value;
            labelUsedMap.put(item.label, labelUsed + 1);
        }

        return result;
    }

    private static class Item implements Comparable<Item> {
        private final int value, label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }

        @Override
        public int compareTo(Item o) {
            return o.value - this.value;
        }
    }
}
// @lc code=end

