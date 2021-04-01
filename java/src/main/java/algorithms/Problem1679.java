package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 1679.K和数对的最大数目
 */


class Problem1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        int count = 0;

        for (int num : nums) {
            int diff = k - num;

            // 一定找不到匹配数
            if (diff <= 0) {
                continue;
            }

            int remain = map.getOrDefault(diff, 0);
            if (remain > 0) {
                // 找到匹配的数
                count++;
                map.put(diff, remain - 1);
            } else {
                map.merge(num, 1, Integer::sum);
            }
        }

        return count;
    }
}
