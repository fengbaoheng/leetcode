/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Item> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.computeIfAbsent(num, Item::new).increase();
        }

        List<Integer> result = new ArrayList<>(nums.length);

        map.values().stream().sorted().forEach(item -> {
            for (int i = 0; i < item.count; i++) {
                result.add(item.value);
            }
        });

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Item implements Comparable<Item> {
        private final int value;
        private int count;

        public Item(int value) {
            this.value = value;
        }

        public void increase() {
            this.count++;
        }
        
        @Override
        public int compareTo(Item o) {
            return this.count != o.count ? this.count - o.count : o.value - this.value;
        }
    }
}
// @lc code=end

