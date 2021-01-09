package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 1695.删除子数组的最大得分
 */

class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        // 每个数字右侧下一次出现同元素的位置
        Map<Integer, Integer> rightIndex = new HashMap<>(n);
        int maxSum = 0;

        // 从后向前双指针更新
        int q = n;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            sum += num;

            int right = rightIndex.getOrDefault(num, n);
            if (right < q) {
                // 收缩右侧区间到right位置
                do {
                    sum -= nums[--q];
                } while (q > right);
            }

            // 更新最大和
            maxSum = Math.max(maxSum, sum);

            // 更新右边界索引
            rightIndex.put(num, i);
        }

        return maxSum;
    }
}
